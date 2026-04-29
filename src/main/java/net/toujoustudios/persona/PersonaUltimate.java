package net.toujoustudios.persona;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.toujoustudios.persona.event.AsyncChatListener;
import net.toujoustudios.persona.event.PlayerJoinListener;
import net.toujoustudios.persona.event.PlayerQuitListener;
import net.toujoustudios.persona.player.PersonaManager;
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

    /**
     * This method is called when the plugin is loaded. It will call pre-, main- and post-initialization steps.
     */
    @Override
    public void onEnable() {
        instance = this;
        preInitialize();
        initialize();
        postInitialize();
    }

    /**
     * Pre-initialization logic for the plugin. Configuration setup, database connection, anything
     * required for most classes to work goes here.
     *
     * @see PersonaUltimate#initialize()
     * @see PersonaUltimate#postInitialize()
     */
    private void preInitialize() {

    }

    /**
     * Initialization logic for the plugin. Most of the core functionality goes here, like class
     * loading, item registration, etc.
     *
     * @see PersonaUltimate#preInitialize()
     * @see PersonaUltimate#postInitialize()
     */
    private void initialize() {

    }

    /**
     * Post-initialization logic for the plugin. Anything that needs to be done after the plugin
     * has finished initializing, such as registering events, commands, etc.
     *
     * @see PersonaUltimate#preInitialize()
     * @see PersonaUltimate#initialize()
     */
    private void postInitialize() {
        registerEvents();
        PersonaManager.saveAll();
    }

    /**
     * Registers all event listeners for the plugin.
     */
    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new AsyncChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
    }

}
