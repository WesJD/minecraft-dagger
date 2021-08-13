package dev.wesleysmith.minecraftdagger;

import dev.wesleysmith.minecraftdagger.di.BukkitDIModule;
import dev.wesleysmith.minecraftdagger.di.DaggerApplicationComponent;
import dev.wesleysmith.minecraftdagger.di.PluginDIModule;
import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftDaggerPlugin extends JavaPlugin {

    private MinecraftDaggerApplication application;

    @Override
    public void onEnable() {
        application = DaggerApplicationComponent.builder()
                .bukkitDIModule(new BukkitDIModule())
                .pluginDIModule(new PluginDIModule(this))
                .build()
                .getApplication();
        application.enable();
    }

    @Override
    public void onDisable() {
        application.disable();
    }

}
