package dev.wesleysmith.minecraftdagger.player;

import dev.wesleysmith.minecraftdagger.MinecraftDaggerPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CustomPlayerManager implements Listener {

    private final Map<Player, CustomPlayer> customPlayers = new HashMap<>();

    @Inject
    public CustomPlayerManager(MinecraftDaggerPlugin plugin, PluginManager pluginManager) {
        pluginManager.registerEvents(this, plugin);
    }

    public CustomPlayer getCustomPlayer(Player player) {
        return customPlayers.get(player);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLogin(PlayerLoginEvent event) {
        final Player player = event.getPlayer();
        customPlayers.put(player, new CustomPlayer(player, Instant.now()));
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onQuit(PlayerQuitEvent event) {
        customPlayers.remove(event.getPlayer());
    }

}
