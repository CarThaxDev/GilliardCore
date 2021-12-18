package com.github.carthax08.gilliardcore.handlers;

import com.github.carthax08.gilliardcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CustomChatHandler implements Listener {

    @EventHandler
    public void onPlayerSendMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        int distance = Main.getConfigObj().getInt("chat.channels.talk.distance");
        for (Player player2 : Bukkit.getOnlinePlayers()) {
            if (player2.getLocation().distance(player.getLocation()) <= distance) {
                player2.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getConfigObj().getString("chat.channels.talk.prefix")) + event.getMessage());
            }
        }
    }
    public void commandPreProcess(PlayerCommandPreprocessEvent e){
        Player player = e.getPlayer();
        boolean other_channel = false;
        String channel = "";
        for (String string : Main.getConfigObj().getStringList("chat-channels")) {
            if (other_channel) continue;
            if (e.getMessage().startsWith("/" + string)) {
                int distance = Main.getConfigObj().getInt("chat.channels." + string + ".distance");
                for (Player player2 : Bukkit.getOnlinePlayers()) {
                    if (player2.getLocation().distance(player.getLocation()) <= distance) {
                        player2.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.getConfigObj().getString("chat.channels." + string + ".prefix")));
                        other_channel = true;
                        channel = string;
                    }
                }
            }
        }
    }
}
