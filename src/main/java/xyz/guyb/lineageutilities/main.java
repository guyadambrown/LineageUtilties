package xyz.guyb.lineageutilities;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.guyb.lineageutilities.commands.fun.DemoCommand;
import xyz.guyb.lineageutilities.commands.fun.LaunchCommand;
import xyz.guyb.lineageutilities.commands.utility.*;
import xyz.guyb.lineageutilities.events.SpawnOutOfWorld;
import xyz.guyb.lineageutilities.events.customJoinLeave;
import xyz.guyb.lineageutilities.events.firstJoinMessage;

import java.util.Objects;

public class main extends JavaPlugin {
    public static main plugin;
    FileConfiguration config = getConfig();
    String enableMessage = config.getString("globalOptions.messages.enable");
    String disableMessage = config.getString("globalOptions.messages.disable");

    @Override
    public void onEnable(){
        getLogger().info(enableMessage);
        plugin = this;
        saveDefaultConfig();

        //Register fun commands
        Objects.requireNonNull(getCommand("launch")).setExecutor(new LaunchCommand());
        Objects.requireNonNull(getCommand("demo")).setExecutor(new DemoCommand());

        //Register utility commands
        Objects.requireNonNull(getCommand("bed")).setExecutor(new BedTeleport());
        Objects.requireNonNull(getCommand("ping")).setExecutor(new PingCommand());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new BroadcastCommand());
        Objects.requireNonNull(getCommand("discord")).setExecutor(new DiscordCommand());
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());

        //Register Events
        getServer().getPluginManager().registerEvents(new SpawnOutOfWorld(),this);
        getServer().getPluginManager().registerEvents(new firstJoinMessage(),this);
        getServer().getPluginManager().registerEvents(new customJoinLeave(),this);
    }

    @Override
    public void onDisable(){
        getLogger().info(disableMessage);
    }


}
