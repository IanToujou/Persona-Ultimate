package net.toujoustudios.persona.event;

import net.toujoustudios.persona.player.PersonaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Event listener for the player join event.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        PersonaManager.get(event.getPlayer());
    }

}
