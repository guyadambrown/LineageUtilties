package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.guyb.lineageutilities.main;

public class FlyCommand implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String notOnline = config.getString("globalOptions.messages.notOnline");
    String playerNameError = config.getString("globalOptions.messages.playerNameError");
    String flightEnabledSelf = config.getString("commands.fly.messages.flightEnabledSelf");
    String flightDisabledSelf = config.getString("commands.fly.messages.flightDisabledSelf");
    String flightEnabledOther = config.getString("commands.fly.messages.flightEnabledOther");
    String flightDisabledOther = config.getString("commands.fly.messages.flightDisabledOther");

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0){
            if (commandSender.hasPermission("lineageUtilities.fly")){
                if (commandSender instanceof Player player){
                    if (player.getAllowFlight()){
                        player.setAllowFlight(false);
                        player.sendMessage(prefix + flightDisabledSelf);
                    }else {
                        player.setAllowFlight(true);
                        player.sendMessage(prefix + flightEnabledSelf);
                    }
                }else {
                    commandSender.sendMessage(prefix + playerNameError);
                }
            }

        }else {
            if (commandSender.hasPermission("lineageUtilities.fly.other")) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null) {
                    commandSender.sendMessage(prefix + notOnline);
                } else {
                    if (target.getAllowFlight()) {
                        target.setAllowFlight(false);
                        commandSender.sendMessage(prefix + flightDisabledOther.replace("%player%", target.getDisplayName()));
                    } else {
                        target.setAllowFlight(true);
                        commandSender.sendMessage(prefix + flightEnabledOther.replace("%player%", target.getDisplayName()));
                    }
                }
            }
        }
        return true;
    }
}
