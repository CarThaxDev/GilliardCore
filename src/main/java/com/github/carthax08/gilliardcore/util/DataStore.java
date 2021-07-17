package com.github.carthax08.gilliardcore.util;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class DataStore {
    public static HashMap<Player, WantedListEntry> wantedDataMap = new HashMap<>();
    public static HashMap<Player, String> playerVerifyDataMap = new HashMap<>();
}
