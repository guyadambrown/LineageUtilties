package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.guyb.lineageutilities.main;

public class PingCommand implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String notOnline = config.getString("globalOptions.messages.notOnline");
    String playerNameError = config.getString("globalOptions.messages.playerNameError");
    String selfPing = config.getString("commands.ping.messages.selfPing");
    String otherPing = config.getString("commands.ping.messages.otherPing");


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0){
            if (commandSender instanceof Player player){
                if (player.hasPermission("lineageUtilities.ping")){
                    int ping = player.getPing();
                    String pingString = Integer.toString(ping);
                    player.sendMessage(prefix + selfPing.replace("%ping%",pingString));
                }
            }else {
                commandSender.sendMessage(prefix + playerNameError);
            }
        }else {
            Player target = Bukkit.getPlayer(strings[0]);
            if (target == null){
                commandSender.sendMessage(prefix + notOnline);
            }else {
                int ping = target.getPing();

                String pingString = Integer.toString(ping);
                String playerMessage = otherPing.replace("%player%",target.getDisplayName()).replace("%ping%",pingString);
                commandSender.sendMessage(prefix + playerMessage);
            }
        }
        return true;
    }
}