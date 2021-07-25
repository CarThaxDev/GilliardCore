package com.github.carthax08.gilliardcore.economy.workers;

import com.github.carthax08.gilliardcore.Main;
import com.github.carthax08.gilliardcore.economy.util.EconomyUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class TaxWorker {
    private long period;
    private BukkitTask workerTask;

    public TaxWorker(long period){
        this.period = period;
    }

    public void workerMethod(){
        for(Player player : Bukkit.getOnlinePlayers()){
            EconomyUtil.getBalanceForPlayer();
        }
    }
    public void start(){
        workerTask = Bukkit.getScheduler().runTaskTimer(Main.getInstance(), this::workerMethod, 0L, period);
    }
    public void stop(){
        if(workerTask.isCancelled() || workerTask == null) return;
        workerTask.cancel();
    }
}
