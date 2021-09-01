package com.github.carthax08.gilliardcore.util;

import com.github.carthax08.gilliardcore.data.GilliardPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class DataStore {
    public static HashMap<Player, WantedListEntry> wantedDataMap = new HashMap<>();
    public static HashMap<String, Player> playerVerifyDataMap = new HashMap<>();
    public static HashMap<Player, GilliardPlayer> playerData = new HashMap<>();
}
