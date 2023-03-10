package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.guyb.lineageutilities.main;

public class BedTeleport implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String playerNameError = config.getString("globalOptions.messages.playerNameError");
    String notOnline = config.getString("globalOptions.messages.notOnline");
    String tpSound = config.getString("globalOptions.tpSound");
    String obstructedBed = config.getString("commands.bedTeleport.messages.obstructedBed");
    String teleported = config.getString("commands.bedTeleport.messages.teleported");

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0){
            if (commandSender instanceof Player player){
                if (player.hasPermission("lineageUtilities.bed")){
                    Location bedSpawn = player.getBedSpawnLocation();
                    if (bedSpawn != null){
                        player.teleport(bedSpawn);
                        player.sendMessage(prefix + teleported);
                        player.playSound(player.getLocation(), Sound.valueOf(tpSound), 1,1);
                    }else {
                        player.sendMessage(prefix + obstructedBed);
                    }
                }
            }else {
                commandSender.sendMessage(prefix + playerNameError);
            }
        }else {
            if (commandSender.hasPermission("lineageUtilities.bed.others")){
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null){
                    commandSender.sendMessage(prefix + notOnline);
                }else {
                    Location bedSpawn = target.getBedSpawnLocation();
                    if (bedSpawn == null){
                        commandSender.sendMessage(prefix + obstructedBed);
                    }else {
                        target.teleport(bedSpawn);
                        target.playSound(target.getLocation(), Sound.valueOf(tpSound), 0,0);
                        target.sendMessage(prefix + teleported);
                    }
                }
            }
        }
        return true;
    }
}
