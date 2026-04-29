package net.toujoustudios.persona.player;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

@Accessors(fluent = true)
public class PersonaManager {

    @Getter
    private static final HashMap<UUID, Persona> instances = new HashMap<>();

    public static Persona get(Player player) {
        return get(player.getUniqueId());
    }

    public static Persona get(UUID uuid) {
        return instances.computeIfAbsent(uuid, Persona::new);
    }

    public static void save(UUID uuid) {
        Persona persona = instances.get(uuid);
        if (persona != null) persona.save();
    }

    public static void saveAll() {
        if (instances.isEmpty()) return;
        instances.forEach((uuid, persona) -> persona.save());
    }

}
