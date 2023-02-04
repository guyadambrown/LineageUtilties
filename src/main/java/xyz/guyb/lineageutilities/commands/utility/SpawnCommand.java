package xyz.guyb.lineageutilities.commands.utility;
import org.bukkit.Location;
import org.bukkit.World;
import xyz.guyb.lineageutilities.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class SpawnCommand implements CommandExecutor {
    World world = Bukkit.getWorlds().get(0);
    Location spawn = world.getSpawnLocation();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("lineageutilities.spawn")){
            if (commandSender instanceof Player){


            }else {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null){
                    Bukkit.getConsoleSender().sendMessage("§6Server §7» §aPlayer not found.");
                }else {
                    target.teleport(spawn);
                }
            }
        }

        return true;
    }
}
