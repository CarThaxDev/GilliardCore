package com.github.carthax08.gilliardcore.events;

import com.github.carthax08.gilliardcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onPlayerSendMessage implements Listener {

    @EventHandler
    public void onPlayerSendMessageEvent(AsyncPlayerChatEvent e){
        FileConfiguration config = Main.getConfigObj();
        double defaultDistance = config.getDouble("channels." + config.getString("channels.Default-Channel") + ".range");
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getLocation().distance(e.getPlayer().getLocation()) <= defaultDistance){
                //TODO: Message Sending and Prefixes
                player.sendMessage();
            };
        }


        e.setCancelled(true);
    }

}
