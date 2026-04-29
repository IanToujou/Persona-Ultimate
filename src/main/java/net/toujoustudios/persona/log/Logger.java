package net.toujoustudios.persona.log;

import net.toujoustudios.persona.PersonaUltimate;

/**
 * A custom logging system for the plugin. It supports debug logging and different log output levels.
 * <p>
 * Essentially, it is just a wrapper around the Paper logger.
 *
 * @author Toujou Studios
 * @since 1.0.0
 */
public class Logger {

    /**
     * Static class cannot be instantiated.
     */
    private Logger() {}

    /**
     * Logs a provided message with a specific level.
     *
     * @param level The level of the output.
     * @param message The message that should be displayed.
     */
    public static void log(LogLevel level, String message) {
        switch (level) {
            case INFO -> PersonaUltimate.instance().getComponentLogger().info(message);
            case WARN -> PersonaUltimate.instance().getComponentLogger().warn(message);
            case ERROR -> PersonaUltimate.instance().getComponentLogger().error(message);
            case DEBUG -> PersonaUltimate.instance().getComponentLogger().debug(message);
            case TRACE -> PersonaUltimate.instance().getComponentLogger().trace(message);
        }
    }

}
