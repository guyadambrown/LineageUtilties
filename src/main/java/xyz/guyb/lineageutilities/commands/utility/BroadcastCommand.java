package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String message = String.join(" ", strings);

        if (commandSender.hasPermission("lineagestuff.broadcast")) {
            Bukkit.broadcastMessage("§6Server §7» §r" + message);
            return true;
        }

        return true;
    }
}