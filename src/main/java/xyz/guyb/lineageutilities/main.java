package xyz.guyb.lineageutilities;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.guyb.lineageutilities.commands.fun.LaunchCommand;
import xyz.guyb.lineageutilities.commands.utility.BedTeleport;

import java.util.Objects;

public class main extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("LineageUtilities has been enabled");
        //Load fun commands
        Objects.requireNonNull(getCommand("launch")).setExecutor(new LaunchCommand());
        Objects.requireNonNull(getCommand("bedtp")).setExecutor(new BedTeleport());
    }


    @Override
    public void onDisable(){
        getLogger().info("LineageUtilities has been Disabled");
    }
}
