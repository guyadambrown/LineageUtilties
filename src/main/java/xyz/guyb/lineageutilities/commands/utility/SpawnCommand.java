package xyz.guyb.lineageutilities.commands.utility;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import xyz.guyb.lineageutilities.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class SpawnCommand implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String teleport = config.getString("commands.spawn.messages.teleport");
    String playerNameError = config.getString("globalOptions.messages.playerNameError");
    String playerNotOnline = config.getString("globalOptions.messages.notOnline");
    String sent = config.getString("commands.spawn.messages.sent");
    String tpSound = config.getString("globalOptions.tpSound.name");
    World world = Bukkit.getWorlds().get(0);
    Location spawn = world.getSpawnLocation();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0){
            if (commandSender instanceof Player player){
                if (commandSender.hasPermission("lineageUtilities.spawn")){
                    commandSender.sendMessage(prefix + teleport);
                    player.playSound(player.getLocation() , Sound.valueOf(tpSound),1,1);
                    player.teleport(spawn);
                }
            }else {
                commandSender.sendMessage(prefix + playerNameError);
            }
        }else {
            if (commandSender.hasPermission("lineageUtilities.spawn.others")){
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null){
                    commandSender.sendMessage(prefix + playerNotOnline);
                }else {
                    target.playSound(target.getLocation(), Sound.valueOf(tpSound),0,0);
                    target.teleport(spawn);
                    target.sendMessage(prefix + teleport);
                    commandSender.sendMessage(prefix + sent.replace("%player%", target.getDisplayName()));
                }
            }
        }

        return false;
    }
}
