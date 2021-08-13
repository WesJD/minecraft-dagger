package dev.wesleysmith.minecraftdagger.command;

import dev.wesleysmith.minecraftdagger.player.CustomPlayer;
import dev.wesleysmith.minecraftdagger.player.CustomPlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class SuicideCommand implements CommandExecutor {

    private final CustomPlayerManager playerManager;

    @Inject
    public SuicideCommand(CustomPlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("You must be a player.");
            return false;
        }

        final CustomPlayer player = playerManager.getCustomPlayer((Player) sender);
        player.setHealth(0L);

        final int newSuicideCount = player.getSuicideCount() + 1;
        player.setSuicideCount(newSuicideCount);
        player.sendMessage("Your suicide count is now " + newSuicideCount + " for this session.");
        return false;
    }

}
