package com.github.carthax08.gilliardcore.economy.util;

import com.github.carthax08.gilliardcore.util.DataStore;
import org.bukkit.entity.Player;

public class EconomyUtil {
    public static double getBalanceForPlayer(Player player){

        return DataStore.playerData.get(player).money;
    }

    public static void setBalanceForPlayer(double l) {
    }
}
