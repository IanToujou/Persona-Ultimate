package net.toujoustudios.persona.config;

import net.toujoustudios.persona.PersonaUltimate;
import net.toujoustudios.persona.log.LogLevel;
import net.toujoustudios.persona.log.Logger;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * The Config class is responsible for managing the configuration files
 * used by the plugin. It supports operations such as initializing
 * default values, loading configurations from YAML files, and saving updates
 * back to the disk.
 * <p>
 * This class is also used as an interface to interact with persistent data,
 * if stored on the disk instead of a database.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public class Config {

    /**
     * Gets a configuration file from the plugin data folder.
     *
     * @param filename The name of the file to retrieve.
     * @return The configuration file object.
     */
    public static YamlConfiguration file(String filename) {
        File file = new File("plugins/" + PersonaUltimate.instance().getName() + "/" + filename);
        return YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Saves a configuration file to the plugin data folder.
     *
     * @param configuration The configuration to save.
     * @param filename The name of the file to save to.
     */
    public static void save(YamlConfiguration configuration, String filename) {
        File file = new File("plugins/" + PersonaUltimate.instance().getName() + "/" + filename);
        try {
            configuration.save(file);
        } catch (IOException exception) {
            Logger.log(LogLevel.ERROR, "Failed to write config file " + file.getName());
        }
    }

}
