package com.github.carthax08.gilliardcore.util;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WantedListEntry {
    @Getter @Setter
    private int wantedLevel;
    @Getter @Setter
    private ArrayList<String> wantedReasons;
    @Getter @Setter
    private Player addingPlayer;
    @Getter @Setter
    private Player wantedPlayer;
    public WantedListEntry(int wantedLevel, ArrayList<String> wantedFor, Player addingPlayer, Player wantedPlayer){
        if(wantedLevel < 1 || wantedLevel > 5){
            throw new IllegalArgumentException("Wanted Level provided for player " + wantedPlayer.getName() + " was not between 1 and 5!");
        }
        this.addingPlayer = addingPlayer;
        this.wantedPlayer = wantedPlayer;
        this.wantedReasons = wantedFor;
        this.wantedLevel = wantedLevel;
    }
}
