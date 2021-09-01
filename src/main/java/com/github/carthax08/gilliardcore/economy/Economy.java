package com.github.carthax08.gilliardcore.economy;

import com.github.carthax08.gilliardcore.economy.files.PlayerData;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;

public class Economy {

    public HashMap<Player, Double> economyMap = new HashMap<>();

    Economy() {

    }

    public void loadEconForPlayer(Player player) throws IOException {
        economyMap.put(
                player,
                PlayerData.getYMLForPlayer(player).getDouble("money")
        );
    }

}
