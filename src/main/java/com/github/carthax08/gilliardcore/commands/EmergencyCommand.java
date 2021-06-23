package com.github.carthax08.gilliardcore.commands;

import com.github.carthax08.gilliardcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class EmergencyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("emergency.send")){
            FileConfiguration config = Main.getConfigObj();
            String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("chat-prefixes.emergency"));
            StringBuilder message = new StringBuilder();
            for(String string : args){
                message.append(string).append(" ");
            }
            Bukkit.broadcast(prefix + ChatColor.RED + message, "emergency.receive");
        }


        return true;
    }
}
