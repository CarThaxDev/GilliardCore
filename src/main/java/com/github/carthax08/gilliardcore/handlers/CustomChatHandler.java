package com.github.carthax08.gilliardcore.handlers;

import com.github.carthax08.gilliardcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CustomChatHandler implements Listener {

    @EventHandler
    public void onPlayerSendMessage(AsyncPlayerChatEvent event) {
        boolean other_channel = false;
        Player player = event.getPlayer();
        event.setCancelled(true);
        for (String string : Main.getConfigObj().getStringList("chat-channels")) {
            if (other_channel) continue;
            if (event.getMessage().startsWith("/" + string)) {
                int distance = Main.getConfigObj().getInt("chat.channels." + string + ".distance");
                for (Player player2 : Bukkit.getOnlinePlayers()) {
                    if (player2.getLocation().distance(player.getLocation()) <= distance) {
                        player2.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getConfigObj().getString("chat.channels." + string + ".prefix")) + event.getMessage());
                        other_channel = true;
                    }
                }
            }
        }
        if (!other_channel) {
            int distance = Main.getConfigObj().getInt("chat.channels.talk.distance");
            for (Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2.getLocation().distance(player.getLocation()) <= distance) {
                    player2.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getConfigObj().getString("chat.channels.talk.prefix")) + event.getMessage());
                }
            }
        }
    }

}
