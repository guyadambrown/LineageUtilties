package xyz.guyb.lineageutilities.commands.utility.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.guyb.lineageutilities.main;

public class AdventureCommand implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String playerNameError = config.getString("globalOptions.messages.playerNameError");
    String notOnline = config.getString("globalOptions.messages.notOnline");
    String selfGameMode = config.getString("commands.gameMode.messages.selfGameMode");
    String otherGameMode = config.getString("commands.gameMode.messages.otherGameMode");
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0){
            if (commandSender instanceof Player player){
                if (player.hasPermission("lineageUtilities.adventure")){
                    player.setGameMode(GameMode.ADVENTURE);
                    commandSender.sendMessage(prefix + selfGameMode.replace("%mode%", "adventure"));
                }
            }else {
                // Console no argument.
                commandSender.sendMessage(prefix + playerNameError);
            }
        }else {
            if (commandSender.hasPermission("lineageUtilities.adventure.others")){
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null){
                    commandSender.sendMessage(prefix + notOnline);
                }else {
                    target.setGameMode(GameMode.ADVENTURE);
                    target.sendMessage(prefix + selfGameMode.replace("%mode%", "adventure"));
                    commandSender.sendMessage(prefix + otherGameMode.replace("%mode%", "adventure").replace("%player%", target.getDisplayName()));
                    

                }
            }
        }
        return true;

    }
}
