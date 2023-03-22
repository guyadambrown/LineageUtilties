package xyz.guyb.lineageutilities.commands.utility.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.guyb.lineageutilities.main;

public class SurvivalCommand implements CommandExecutor {
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
                if (player.hasPermission("lineageUtilities.survival")){
                    player.setGameMode(GameMode.SURVIVAL);
                    commandSender.sendMessage(prefix + selfGameMode.replace("%mode%", "survival"));
                }
            }else {
                // Console no argument.
                commandSender.sendMessage(prefix + playerNameError);
            }
        }else {
            if (commandSender.hasPermission("lineageUtilities.survival.others")){
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null){
                    commandSender.sendMessage(prefix + notOnline);
                }else {
                    target.setGameMode(GameMode.SURVIVAL);
                    target.sendMessage(prefix + selfGameMode.replace("%mode%", "survival"));
                    commandSender.sendMessage(prefix + otherGameMode.replace("%mode%", "survival").replace("%player%", target.getDisplayName()));


                }
            }
        }
        return true;
    }
}
