package com.github.carthax08.gilliardcore.economy.events;

import com.github.carthax08.gilliardcore.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;


public class PlayerJoinEvent implements Listener {
    @EventHandler
    public void playerJoinEvent(org.bukkit.event.player.PlayerJoinEvent e) throws IOException {
        Main.econ.loadEconForPlayer(e.getPlayer());
    }
}
