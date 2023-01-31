package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (strings.length == 0){
                if (player.hasPermission("lineageutilities.ping")){
                    int PlayerPing = player.getPing();
                    player.sendMessage("§6Server §7» §rPing: " + PlayerPing + "ms");
                }
            }else {
                if (player.hasPermission("lineageutilities.ping.others")){
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null){
                        player.sendMessage("§6Server §7» §cPlayer not found.");
                    }else {
                        int PlayerPing = target.getPing();
                        player.sendMessage("§6Server §7» §r"+target.getName()+ "'s ping: " + PlayerPing + "ms");
                    }
                }
            }
        }else {
            return true;
            // Console logic
        }
        return true;
    }
}
