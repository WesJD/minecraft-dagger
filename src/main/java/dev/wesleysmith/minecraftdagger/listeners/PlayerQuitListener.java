package dev.wesleysmith.minecraftdagger.listeners;

import dev.wesleysmith.minecraftdagger.player.CustomPlayer;
import dev.wesleysmith.minecraftdagger.player.CustomPlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;

public class PlayerQuitListener implements Listener {

    private final CustomPlayerManager playerManager;

    @Inject
    public PlayerQuitListener(CustomPlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        final CustomPlayer player = playerManager.getCustomPlayer(event.getPlayer());
        event.setQuitMessage("See you later, " + player.getName() + "! You played for "
                + Duration.between(player.getLoginTime(), Instant.now()).toSeconds() + " seconds.");
    }

}
