package net.toujoustudios.persona.player;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

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

    private final UUID uuid;
    private String firstName;
    private String lastName;

    public Persona(UUID uuid) {
        this.uuid = uuid;
    }

    public void save() {

    }

    public Component displayName() {
        return Component.text(firstName + " " + lastName, TextColor.color(0xFF0077));
    }

}
