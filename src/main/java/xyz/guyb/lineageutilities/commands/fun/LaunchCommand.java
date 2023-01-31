package xyz.guyb.lineageutilities.commands.fun;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class LaunchCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission("lineageutilities.commands.fun.Launch")){
                player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 100, 1);
                player.addPotionEffect(PotionEffectType.LEVITATION.createEffect(20,50));
                player.sendMessage("§6Server §7» §rWe have liftoff!!");
            }
        }else {
            //Console
            return true;
        }
        return false;
    }
}

