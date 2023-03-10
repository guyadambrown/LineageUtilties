package xyz.guyb.lineageutilities.events;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import xyz.guyb.lineageutilities.main;

public class SpawnOutOfWorld implements Listener {
    FileConfiguration config = main.plugin.getConfig();
    boolean enabled = config.getBoolean("spawnOutOfWorld.enabled");
    double yLevel = config.getDouble("spawnOutOfWorld.yLevel");
    String spawnMessage = config.getString("commands.spawn.messages.teleport");
    String prefix = config.getString("globalOptions.messages.prefix");


    @EventHandler
    public void outOfWorldEvent(PlayerMoveEvent moveEvent){

        Player player = moveEvent.getPlayer();
        if (enabled){
            if (player.getLocation().getY() < yLevel){
                player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
                player.sendMessage(prefix + spawnMessage);
            }
        }
    }
}
