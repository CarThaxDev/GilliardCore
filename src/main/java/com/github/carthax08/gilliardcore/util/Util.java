package com.github.carthax08.gilliardcore.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Util {
    public static void openWantedListGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "Wanted List");
        for (Player player1 : DataStore.wantedDataMap.keySet()) {
            ItemStack item = new ItemStack(Material.SKULL_ITEM);
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta.setOwningPlayer(player1);
            meta.setDisplayName(player1.getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            int wantedLevel = DataStore.wantedDataMap.get(player1).getWantedLevel();
            lore.add("&aWanted Level:");
            lore.add(computeWantedLevelStars(wantedLevel));
            lore.add("&aIssued By:\n" + DataStore.wantedDataMap.get(player1).getAddingPlayer());
            StringBuilder wantedReasons = new StringBuilder();
            for (String string : DataStore.wantedDataMap.get(player1).getWantedReasons()) {
                wantedReasons.append("\n &l-&r   ").append(string);
            }
            lore.add("&aWanted For:\n" + wantedReasons);

            meta.setLore(lore);
            item.setItemMeta(meta);
            inv.addItem(item);
        }
    }

    public static void sendWantedListText(CommandSender sender) {
        ArrayList<String> message = new ArrayList<>();
        for (Player player1 : DataStore.wantedDataMap.keySet()) {
            WantedListEntry entry = DataStore.wantedDataMap.get(player1);
            message.add(entry.toString());
        }
        sender.sendMessage(message.     toArray(new String[0]));
    }

    public static String computeWantedLevelStars(int level) {
        switch (level) {
            case 1:
                return ("&6✯&7✯✯✯✯&r\n\n");
            case 2:
                return ("&6✯✯&7✯✯✯&r\n\n");
            case 3:
                return ("&6✯✯✯&7✯✯&r\n\n");
            case 4:
                return ("&6✯✯✯✯&7✯&r\n\n");
            case 5:
                return ("&6✯✯✯✯✯&r\n\n");
        }
        return("ERROR: Invalid Wanted Level");
    }
}