package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.guyb.lineageutilities.main;

public class HealCommand implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String notOnline = config.getString("globalOptions.messages.notOnline");
    String playerNameError = config.getString("globalOptions.messages.playerNameError");
    String selfHeal = config.getString("commands.heal.messages.selfHeal");
    String targetHeal = config.getString("commands.heal.messages.targetHeal");
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0){
            if (commandSender instanceof Player player){
                if (commandSender.hasPermission("lineageUtilities.heal")){
                    commandSender.sendMessage(prefix + selfHeal);
                    player.setHealth(20);
                    player.setFoodLevel(20);
                }
            }else {
                commandSender.sendMessage(prefix + playerNameError);
            }
        }else {
            if (commandSender.hasPermission("lineageUtilities.heal.other")){
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null){
                    commandSender.sendMessage(prefix + notOnline);
                }else {
                    commandSender.sendMessage(prefix + targetHeal.replace("%player%", target.getDisplayName()));
                    target.setHealth(20);
                    target.setFoodLevel(20);
                    target.sendMessage(prefix + selfHeal);
                }
            }
        }
        return true;
    }
}
