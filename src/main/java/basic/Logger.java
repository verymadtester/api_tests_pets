package basic;

import org.apache.logging.log4j.LogManager;

public class Logger {
    /**
     * Messages are printed in STDOUT
     */
    public static final String CONSOLE = "console";

    public static void info(Object message) {
        getLogger(CONSOLE).info(message);
    }

    public static void warning(Object message) {
        getLogger(CONSOLE).warn(message);
    }

    public static void error(String category, Object message) {
        getLogger(CONSOLE).error(message);
    }

    private static org.apache.logging.log4j.core.Logger getLogger(String name) {
        return (org.apache.logging.log4j.core.Logger) LogManager.getLogger(name);
    }
}
