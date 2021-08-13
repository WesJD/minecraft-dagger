package dev.wesleysmith.minecraftdagger.di;

import dagger.Component;
import dev.wesleysmith.minecraftdagger.MinecraftDaggerApplication;

import javax.inject.Singleton;

@Singleton
@Component(modules = {PluginDIModule.class, BukkitDIModule.class})
public interface ApplicationComponent {

    MinecraftDaggerApplication getApplication();

}
