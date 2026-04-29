package net.toujoustudios.persona.storage;

import net.toujoustudios.persona.config.Config;
import net.toujoustudios.persona.player.Persona;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Performs direct storage operations on player data. This class
 * is responsible for managing player persona data directly.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public class PersonaStorage extends AbstractStorage<UUID, Persona> {

    private static final PersonaStorage instance = new PersonaStorage();

    public static PersonaStorage instance() {
        return instance;
    }

    public static Persona get(Player player) {
        return instance.get(player.getUniqueId(), Persona::new);
    }

    public static Persona get(UUID uuid) {
        return instance.get(uuid, Persona::new);
    }

    @Override
    public void load(UUID uuid, Persona persona) {
        YamlConfiguration config = Config.file("data/player/" + uuid.toString() + ".yml");
        persona.firstName(config.getString("persona.firstName", ""));
        persona.lastName(config.getString("persona.lastName", ""));
    }

    @Override
    public void save(UUID uuid) {
        Persona persona = getInstances().get(uuid);
        if (persona == null)
            return;
        YamlConfiguration config = new YamlConfiguration();
        config.set("persona.firstName", persona.firstName());
        config.set("persona.lastName", persona.lastName());
        Config.save(config, "data/player/" + uuid.toString() + ".yml");
    }

    public static void saveAllPlayers() {
        instance.saveAll();
    }

}
