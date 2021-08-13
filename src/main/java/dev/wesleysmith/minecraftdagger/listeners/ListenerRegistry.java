package dev.wesleysmith.minecraftdagger.listeners;

import dev.wesleysmith.minecraftdagger.MinecraftDaggerPlugin;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import javax.inject.Inject;

public class ListenerRegistry {

    private final MinecraftDaggerPlugin plugin;
    private final PluginManager pluginManager;

    private final PlayerJoinListener playerJoinListener;
    private final PlayerQuitListener playerQuitListener;

    @Inject
    public ListenerRegistry(
            MinecraftDaggerPlugin plugin,
            PluginManager pluginManager,
            PlayerJoinListener playerJoinListener,
            PlayerQuitListener playerQuitListener
    ) {
        this.plugin = plugin;
        this.pluginManager = pluginManager;
        this.playerJoinListener = playerJoinListener;
        this.playerQuitListener = playerQuitListener;
    }

    public void registerListeners() {
        registerListeners(
                playerJoinListener,
                playerQuitListener
        );
    }

    private void registerListeners(Listener... listeners) {
        for(Listener listener : listeners) {
            pluginManager.registerEvents(listener, plugin);
        }
    }

}
