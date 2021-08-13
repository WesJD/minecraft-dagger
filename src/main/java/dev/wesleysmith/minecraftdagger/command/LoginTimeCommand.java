package dev.wesleysmith.minecraftdagger.command;

import dev.wesleysmith.minecraftdagger.player.CustomPlayer;
import dev.wesleysmith.minecraftdagger.player.CustomPlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import java.time.Duration;
import java.time.Instant;

public class LoginTimeCommand implements CommandExecutor {

    private final CustomPlayerManager playerManager;

    @Inject
    public LoginTimeCommand(CustomPlayerManager playerManager) {
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
            sender.sendMessage("Must be a player!");
            return false;
        }

        final CustomPlayer player = playerManager.getCustomPlayer((Player) sender);
        player.sendMessage("You logged in at " + player.getLoginTime() + " and have been online for "
                + Duration.between(player.getLoginTime(), Instant.now()).toSeconds() + " seconds.");
        return false;
    }

}
