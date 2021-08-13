package dev.wesleysmith.minecraftdagger.di;

import dagger.Module;
import dagger.Provides;
import dev.wesleysmith.minecraftdagger.MinecraftDaggerPlugin;

@Module
public class PluginDIModule {

    private final MinecraftDaggerPlugin plugin;

    public PluginDIModule(MinecraftDaggerPlugin plugin) {
        this.plugin = plugin;
    }

    @Provides
    public MinecraftDaggerPlugin provideMinecraftDaggerPlugin() {
        return plugin;
    }

}
