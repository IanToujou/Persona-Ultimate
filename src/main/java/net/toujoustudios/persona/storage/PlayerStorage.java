package net.toujoustudios.persona.storage;

import net.toujoustudios.persona.config.Config;
import net.toujoustudios.persona.player.Persona;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Performs direct storage operations on player data.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public class PlayerStorage {

    public static void save(Persona persona) {
        YamlConfiguration config = new YamlConfiguration();
        config.set("persona.firstName", persona.firstName());
        config.set("persona.lastName", persona.lastName());
        Config.save(config, "data/player/" + persona.uuid().toString() + ".yml");
    }

    public static void load(Persona persona) {
        YamlConfiguration config = Config.file("data/player/" + persona.uuid().toString() + ".yml");
        persona.firstName(config.getString("persona.firstName"));
        persona.lastName(config.getString("persona.lastName"));
    }

}
