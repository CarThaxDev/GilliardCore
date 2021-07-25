package com.github.carthax08.gilliardcore.economy.files;

import com.github.carthax08.gilliardcore.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PlayerData {
    private static HashMap<Player, YamlConfiguration> configMap = new HashMap<>();


    public static YamlConfiguration getYMLForPlayer(Player player) throws IOException {
        if(configMap.containsKey(player)) return configMap.get(player);
        File file = new File(Main.getInstance().getDataFolder().getPath() + player.getUniqueId() + ".yml");
        if(!file.exists()) file.createNewFile();
        configMap.put(player,YamlConfiguration.loadConfiguration(file));
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void saveConfigForPlayer(Player player) throws Exception {
        YamlConfiguration config;
        if(configMap.containsKey(player)){ config = configMap.get(player); }else{throw new Exception("Player provided did not have a YamlConfiguration assigned to them.");}
        File file = new File(Main.getInstance().getDataFolder().getPath() + player.getUniqueId() + ".yml");
        config.save(file);
    }
}
