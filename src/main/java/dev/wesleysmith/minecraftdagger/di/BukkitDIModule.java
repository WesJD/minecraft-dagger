package dev.wesleysmith.minecraftdagger.di;

import dagger.Module;
import dagger.Provides;
import dev.wesleysmith.minecraftdagger.MinecraftDaggerPlugin;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;

import javax.inject.Inject;

@Module
public class BukkitDIModule {

    @Provides
    @Inject
    public Server provideServer(MinecraftDaggerPlugin plugin) {
        return plugin.getServer();
    }

    @Provides
    @Inject
    public PluginManager providePluginManager(Server server) {
        return server.getPluginManager();
    }

}
