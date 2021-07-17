package com.github.carthax08.gilliardcore.commands;

import com.github.carthax08.gilliardcore.util.DataStore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Random;

public class VerifyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.RED + "The server console CANNOT run this command");
        }else{
            Player player = ((Player) sender);
            Random random = new Random();
            char[] usableCharacters ="123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            StringBuilder randomCode = new StringBuilder();
            for(int i = 1; i < 9; i++){
                randomCode.append(usableCharacters[random.nextInt(usableCharacters.length)]);
            }
            DataStore.playerVerifyDataMap.put(player, randomCode.toString());
            player.sendMessage(ChatColor.GREEN + "Send /verify " + randomCode + " in the bot-commands channel in the Gilliard RP Discord or to the Gilliard RP Verification Discord Bot.");
        }
        return true;
    }
}
