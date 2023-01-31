package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player){
            if (strings.length == 0){
                if (player.hasPermission("lineageutilities.fly")){
                    if (player.getAllowFlight()){
                        player.setAllowFlight(false);
                        player.sendMessage("§6Server §7» §cFlight has been disabled.");
                    }else {
                        player.setAllowFlight(true);
                        player.sendMessage("§6Server §7» §aFlight has been enabled.");
                    }
                }
            }else {
                // Argument has been supplied
                Player target = Bukkit.getPlayer(strings[0]);
                if (player.hasPermission("lineageutilities.fly.others")){
                    if (target != null){
                        if (target.getAllowFlight()){
                            target.setAllowFlight(false);
                            target.sendMessage("§6Server §7» §cFlight has been disabled.");
                            player.sendMessage("§6Server §7» §cFlight has been disabled for "+ target.getDisplayName()+".");
                        }else {
                            target.setAllowFlight(true);
                            target.sendMessage("§6Server §7» §aFlight has been enabled.");
                            player.sendMessage("§6Server §7» §aFlight has been enabled for "+ target.getDisplayName()+".");
                        }
                    }
                }
            }
        }

        return true;
    }
}
