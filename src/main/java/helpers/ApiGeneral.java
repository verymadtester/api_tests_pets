package helpers;

import basic.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.google.api.client.http.HttpMethods.PATCH;

public class ApiGeneral {

    public static String sendRequest(String request, String requestMethod, String body) {
        Logger.info("Request method: " + requestMethod + ", Request URL: " + request);

        if (requestMethod.equals(PATCH))
            allowMethods("PATCH");

        final long then = System.currentTimeMillis();
        HttpURLConnection connection;
        try {
            URL urlForRequest = new URL(request);

            connection = (HttpURLConnection) urlForRequest.openConnection();
            connection.setRequestMethod(requestMethod);

            if (body != null) {
                connection.setDoOutput(true);
                connection.addRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Content-Length", Integer.toString(body.length()));
                connection.getOutputStream().write(body.getBytes(StandardCharsets.UTF_8));
            }

            BufferedReader in;
            int responseCode = connection.getResponseCode();

            if (responseCode >= 200 && responseCode < 400) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();

            int BUFFER_SIZE = 1024;
            char[] buffer = new char[BUFFER_SIZE]; // or some other size,
            int charsRead;
            while ((charsRead = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
                response.append(buffer, 0, charsRead);
            }
            if (responseCode >= 400) {
                Logger.error("ERROR", "Endpoint returned response: " + response);
            }
            in.close();
            connection.disconnect();

            final long millis = System.currentTimeMillis() - then;
            Logger.info("Endpoint returned code: " + responseCode + ", time: " + millis + " ms.");
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            methodsField.setAccessible(true);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null/*static field*/, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
