package xyz.guyb.lineageutilities.events;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.guyb.lineageutilities.main;

public class customJoinLeave implements Listener {
    FileConfiguration config = main.plugin.getConfig();

    String prefix = config.getString("globalOptions.messages.prefix");

    //JoinMSG
    boolean joinEnabled = config.getBoolean("joinMessage.enabled");
    boolean joinPrefixEnabled = config.getBoolean("joinMessage.prefixEnabled");
    String joinMessage = config.getString("joinMessage.message");

    //LeaveMSG
    boolean leaveEnabled = config.getBoolean("leaveMessage.enabled");
    boolean leavePrefixEnabled = config.getBoolean("leaveMessage.prefixEnabled");
    String leaveMessage = config.getString("leaveMessage.message");

    @EventHandler
    public void playerJoin(PlayerJoinEvent joinEvent){
        if (joinEnabled){
            if (joinPrefixEnabled){
                joinEvent.setJoinMessage(prefix + joinMessage.replace("%player%", joinEvent.getPlayer().getDisplayName()));
            }else {
                joinEvent.setJoinMessage(joinMessage.replace("%player%", joinEvent.getPlayer().getDisplayName()));
            }
        }else {
            joinEvent.setJoinMessage(null);
        }
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent quitEvent){
        if (leaveEnabled) {
            if (leavePrefixEnabled){
                quitEvent.setQuitMessage(prefix + leaveMessage.replace("%player%",quitEvent.getPlayer().getDisplayName()));
            }else {
                quitEvent.setQuitMessage(leaveMessage.replace("%player%", quitEvent.getPlayer().getDisplayName()));
            }
        }else {
            quitEvent.setQuitMessage(null);
        }
    }
}
