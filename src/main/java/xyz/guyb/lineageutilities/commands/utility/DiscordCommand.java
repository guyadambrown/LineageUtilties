package xyz.guyb.lineageutilities.commands.utility;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import xyz.guyb.lineageutilities.main;

public class DiscordCommand implements CommandExecutor {
    FileConfiguration config = main.plugin.getConfig();
    String discordMsg = config.getString("commands.discord.message");
    String prefix = config.getString("globalOptions.messages.prefix");

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender.hasPermission("lineageUtilities.discord")){
            commandSender.sendMessage(prefix + discordMsg);
        }
        return true;
    }
}
