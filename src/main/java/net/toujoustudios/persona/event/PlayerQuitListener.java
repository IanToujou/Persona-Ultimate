package net.toujoustudios.persona.event;

import net.toujoustudios.persona.player.PersonaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Event listener for the player quit event.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        PersonaManager.save(event.getPlayer().getUniqueId());
    }

}
