package xyz.guyb.lineageutilities;

import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
    @Override
    public void onEnable(){
        getLogger().info("LineageUtilities has been enabled");
    }

    @Override
    public void onDisable(){
        getLogger().info("LineageUtilities has been Disabled");
    }
}
