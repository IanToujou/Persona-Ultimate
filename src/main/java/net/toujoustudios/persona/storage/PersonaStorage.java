package net.toujoustudios.persona.storage;

import lombok.Getter;
import net.toujoustudios.persona.config.Config;
import net.toujoustudios.persona.player.Persona;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Performs direct storage operations on player data.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public class PersonaStorage {

    @Getter
    private static final HashMap<UUID, Persona> instances = new HashMap<>();

    public static Persona get(Player player) {
        return get(player.getUniqueId());
    }

    public static Persona get(UUID uuid) {
        return instances.computeIfAbsent(uuid, k -> {
            Persona persona = new Persona(k);
            YamlConfiguration config = Config.file("data/player/" + persona.uuid().toString() + ".yml");
            persona.firstName(config.getString("persona.firstName", ""));
            persona.lastName(config.getString("persona.lastName", ""));
            return persona;
        });
    }

    public static void save(UUID uuid) {
        Persona persona = instances.get(uuid);
        if (persona == null)
            return;
        YamlConfiguration config = new YamlConfiguration();
        config.set("persona.firstName", persona.firstName());
        config.set("persona.lastName", persona.lastName());
        Config.save(config, "data/player/" + persona.uuid().toString() + ".yml");
    }

    public static void saveAll() {
        if (instances.isEmpty()) return;
        instances.forEach((uuid, persona) -> save(uuid));
    }

}
