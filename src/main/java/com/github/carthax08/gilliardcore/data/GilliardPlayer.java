package com.github.carthax08.gilliardcore.data;

import org.bukkit.entity.Player;

public class GilliardPlayer {

    public Player player;
    public double money;
    public Job job;
    public ID id;

    public GilliardPlayer(Player player, double money, Job job, ID id) {
        this.player = player;
        this.money = money;
        this.job = job;
        this.id = id;
    }


}
