package xyz.guyb.lineageutilities.commands.fun;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import xyz.guyb.lineageutilities.main;

public class LaunchCommand implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String prefix = config.getString("globalOptions.messages.prefix");
    String launchMessage = config.getString("commands.launch.message");
    String launchSound = config.getString("commands.launch.sound");
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if (player.hasPermission("lineageUtilities.launch")){
                player.playSound(player.getLocation(), Sound.valueOf(launchSound), 1, 1);
                player.addPotionEffect(PotionEffectType.LEVITATION.createEffect(20,50));
                player.sendMessage(prefix + launchMessage);
            }
        }else {
            //Console
            return true;
        }
        return false;
    }
}

