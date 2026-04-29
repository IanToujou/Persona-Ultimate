package net.toujoustudios.persona.player;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Defines a players in-game character, or "persona". This class manages most of
 * the data associated with a player and can be directly accessed or instantiated
 * by using the player class.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
@Getter
@Setter
@Accessors(fluent = true)
public class Persona {

    @Getter
    private static final HashMap<UUID, Persona> instances = new HashMap<>();

    private final UUID uuid;

    public Persona(UUID uuid) {
        this.uuid = uuid;
    }

    public static Persona get(Player player) {
        return get(player.getUniqueId());
    }

    public static Persona get(UUID uuid) {
        return instances.computeIfAbsent(uuid, Persona::new);
    }

    public void save() {}

    public static void saveAll() {
        if (instances.isEmpty()) return;
        instances.forEach((uuid, persona) -> persona.save());
    }

}
