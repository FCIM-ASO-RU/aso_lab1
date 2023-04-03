package aso_lab1.team_rocket.logger;

import java.util.logging.Logger;

import static java.lang.String.format;

/**
 * Custom Logger for project
 */
public abstract class Log {
    private static final Logger my_log = Logger.getLogger("MyLogger");

    /**
     * Log action in command prompt
     *
     * @param message Message, what should be logged
     */
    public static void info(final String message) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String outerClassName = stackTrace[2].getClassName();
        my_log.info(format("[ %s]: %s", outerClassName, message));
    }

    /**
     * Log string format action
     *
     * @param message Message, what should be logged
     * @param args    args for String.format message
     */
    public static void infoFormat(final String message, final String... args) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String outerClassName = stackTrace[2].getClassName();
        my_log.info(format("[ %s]: %s", outerClassName, format(message, (Object) args)));
    }
}
