package apiMethods;

import apiModels.pets.Pet;
import basic.Logger;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

import static basic.Service.BASE_URL;
import static com.google.api.client.http.HttpMethods.GET;
import static helpers.ApiGeneral.sendRequest;
import static helpers.Endpoints.Commons.PET;
import static helpers.Endpoints.Pets.FIND_BY_STATUS;

public class PetsRequests {

    private static final Gson gson = new GsonBuilder().serializeNulls().create();

    /**
     *
     * @param status - status of pet. Can be available, pending or sold.
     * @return JsonArray of pets with current status
     */
    public static JsonArray getAllPets(String status){
        Logger.info("Get all Pets with status: " + status);
        String stringResponse = sendRequest(BASE_URL+ PET + FIND_BY_STATUS
                + "?status=" + status, GET, null);
        return JsonParser.parseString(stringResponse).getAsJsonArray();
    }

    /**
     *
     * @param status - status of pet. Can be available, pending or sold.
     * @param name - name of requesting pet
     * @return list of found pets
     */
    public static List<String> getPetByName(String status, String name){
        Logger.info("Get all Pets with status: " + status + " and name: " + name);
        Pet pet = new Pet();
        List<String> pets = new ArrayList<>();
        JsonArray response = getAllPets(status);
        for (JsonElement jsonElement : response) {
            pet = gson.fromJson(jsonElement, Pet.class);
            if (pet.getName().contains(name)){
                pets.add(String.valueOf(pet));
            }
        }
        return pets;
    }

    public static int getPetId(String status, String name){
        Pet pet = new Pet();
        int petId = 0;
        JsonArray response = getAllPets(status);
        for (JsonElement jsonElement : response) {
            pet = gson.fromJson(jsonElement, Pet.class);
            if (pet.getName().equals(name)){
               petId = pet.getId();
            }
        }
        return petId;
    }
}
