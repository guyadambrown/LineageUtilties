package xyz.guyb.lineageutilities.commands.fun;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.guyb.lineageutilities.main;

public class DemoCommand implements CommandExecutor {

    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String messageOther = config.getString("commands.demo.messageOther");
    String messageSelf = config.getString("commands.demo.messageSelf");
    String playerNameError = config.getString("globalOptions.messages.playerNameError");
    String notOnline = config.getString("globalOptions.messages.notOnline");
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("lineageUtilities.demo")){
            if (strings.length == 0){
                if (commandSender instanceof Player player){
                    player.showDemoScreen();
                    player.sendMessage(prefix + messageSelf);
                }else {
                    commandSender.sendMessage(prefix + playerNameError);
                }
            }else {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null){
                    commandSender.sendMessage(prefix + notOnline);
                }else {
                    target.showDemoScreen();
                    commandSender.sendMessage(prefix + messageOther.replace("%player%", target.getDisplayName()));
                }
            }
        }

        return true;
    }
}
