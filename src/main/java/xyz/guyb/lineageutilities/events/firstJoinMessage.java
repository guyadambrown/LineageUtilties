package xyz.guyb.lineageutilities.events;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.guyb.lineageutilities.main;

public class firstJoinMessage implements Listener {
    FileConfiguration config = main.plugin.getConfig();
    boolean enabled = config.getBoolean("firstJoinMessage.enabled");
    String prefix = config.getString("globalOptions.messages.prefix");
    String message = config.getString("firstJoinMessage.message");

    @EventHandler
    public void playerMOTD(PlayerJoinEvent joinEvent){

        if (enabled){
            Player player = joinEvent.getPlayer();
            if (!player.hasPlayedBefore()){
                Bukkit.broadcastMessage(prefix + message.replace("%player%",player.getName()));
            }
        }
    }
}
