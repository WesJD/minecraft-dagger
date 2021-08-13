package dev.wesleysmith.minecraftdagger.command;

import dev.wesleysmith.minecraftdagger.MinecraftDaggerPlugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

import javax.inject.Inject;

public class CommandRegistry {

    private final MinecraftDaggerPlugin plugin;

    private final LoginTimeCommand loginTimeCommand;
    private final SuicideCommand suicideCommand;

    @Inject
    public CommandRegistry(
            MinecraftDaggerPlugin plugin,
            LoginTimeCommand loginTimeCommand,
            SuicideCommand suicideCommand
    ) {
        this.plugin = plugin;
        this.loginTimeCommand = loginTimeCommand;
        this.suicideCommand = suicideCommand;
    }

    public void registerCommands() {
        registerCommand("logintime", loginTimeCommand);
        registerCommand("suicide", suicideCommand);
    }

    private void registerCommand(String name, CommandExecutor executor) {
        final PluginCommand pluginCommand = plugin.getCommand(name);
        if(pluginCommand == null) {
            throw new IllegalStateException("Command \"" + name + "\" is not registered.");
        }
        pluginCommand.setExecutor(executor);
    }

}
