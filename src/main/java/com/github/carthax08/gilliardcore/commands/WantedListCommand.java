package com.github.carthax08.gilliardcore.commands;

import com.github.carthax08.gilliardcore.util.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WantedListCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Util.openWantedListGUI(player);

            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player to open the Wanted List GUI");
            }
        }else{
            //TODO: Other Cases
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("text")){
                    Util.sendWantedListText(sender);
                }
            }
        }



        return true;
    }
}
