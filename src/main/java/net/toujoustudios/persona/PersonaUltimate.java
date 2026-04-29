package net.toujoustudios.persona;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Defines the main class of the Persona Ultimate plugin.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
@Accessors(fluent = true)
public final class PersonaUltimate extends JavaPlugin {

    /**
     * Singleton instance to access the plugin from a static context.
     */
    @Getter
    private static PersonaUltimate instance;

    @Override
    public void onEnable() {
        instance = this;
    }

}
