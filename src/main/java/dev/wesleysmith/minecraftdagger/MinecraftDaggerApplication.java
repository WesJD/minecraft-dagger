package dev.wesleysmith.minecraftdagger;

import dev.wesleysmith.minecraftdagger.command.CommandRegistry;
import dev.wesleysmith.minecraftdagger.listeners.ListenerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.bukkit.Server;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class MinecraftDaggerApplication {

    private final Server server;
    private final ListenerRegistry listenerRegistry;
    private final CommandRegistry commandRegistry;

    @Inject
    public MinecraftDaggerApplication(
            Server server,
            ListenerRegistry listenerRegistry,
            CommandRegistry commandRegistry
    ) {
        this.server = server;
        this.listenerRegistry = listenerRegistry;
        this.commandRegistry = commandRegistry;
    }

    void enable() {
        log.info("Enabling plugin for server on port " + server.getPort());
        listenerRegistry.registerListeners();
        commandRegistry.registerCommands();
    }

    void disable() {
        log.info("Disabling plugin for server on port " + server.getPort());
    }

}
