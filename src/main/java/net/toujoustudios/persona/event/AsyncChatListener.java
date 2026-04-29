package net.toujoustudios.persona.event;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jspecify.annotations.NonNull;

/**
 * Event listener for the player chat event.
 *
 * @since 1.0.0
 * @author Toujou Studios
 */
public class AsyncChatListener implements Listener, ChatRenderer {

    @EventHandler
    public void onPlayerChat(AsyncChatEvent event) {
        event.renderer(this);
    }

    @Override
    public @NonNull Component render(@NonNull Player source, Component sourceDisplayName, @NonNull Component message, @NonNull Audience viewer) {
        return sourceDisplayName.append(message);
    }

}
