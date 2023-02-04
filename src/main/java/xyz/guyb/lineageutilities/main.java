package xyz.guyb.lineageutilities;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.guyb.lineageutilities.commands.fun.LaunchCommand;
import xyz.guyb.lineageutilities.commands.utility.BedTeleport;
import xyz.guyb.lineageutilities.commands.utility.BroadcastCommand;
import xyz.guyb.lineageutilities.commands.utility.FlyCommand;
import xyz.guyb.lineageutilities.commands.utility.PingCommand;

import java.util.Objects;

public class main extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("LineageUtilities has been enabled");
        //Load fun commands
        Objects.requireNonNull(getCommand("launch")).setExecutor(new LaunchCommand());
        Objects.requireNonNull(getCommand("bedtp")).setExecutor(new BedTeleport());
        Objects.requireNonNull(getCommand("ping")).setExecutor(new PingCommand());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new BroadcastCommand());
    }


    @Override
    public void onDisable(){
        getLogger().info("LineageUtilities has been Disabled");
    }
}
