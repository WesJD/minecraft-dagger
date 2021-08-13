package dev.wesleysmith.minecraftdagger.listeners;

import dev.wesleysmith.minecraftdagger.player.CustomPlayer;
import dev.wesleysmith.minecraftdagger.player.CustomPlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import javax.inject.Inject;

public class PlayerJoinListener implements Listener {

    private final CustomPlayerManager playerManager;

    @Inject
    public PlayerJoinListener(CustomPlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final CustomPlayer player = playerManager.getCustomPlayer(event.getPlayer());
        event.setJoinMessage("Welcome " + player.getName() + "! You logged in at " + player.getLoginTime() + ".");
    }

}
