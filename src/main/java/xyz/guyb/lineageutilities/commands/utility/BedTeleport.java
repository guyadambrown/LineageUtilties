package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BedTeleport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player){
            if (player.hasPermission("lineageutilities.commands.utility.BedTeleport")){
                Location BedSpawn = player.getBedSpawnLocation();
                if (BedSpawn == null){
                    player.sendMessage("§6Server §7» §cYou do not have a bed spawn set or it is obstructed.");
                }else {
                    player.teleport(BedSpawn);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 100,1);
                    player.sendMessage("§6Server §7» §rYou have been teleported to your bed.");
                }
            }
        }else {
            // Console logic
            return true;
        }
        return true;
    }
}
