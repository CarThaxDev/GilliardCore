package com.github.carthax08.gilliardcore;

import com.github.carthax08.gilliardcore.commands.VerifyCommand;
import com.github.carthax08.gilliardcore.discord.jda.bot.BotMain;
import com.github.carthax08.gilliardcore.economy.Economy;
import com.github.carthax08.gilliardcore.economy.EconomyBuilder;
import com.github.carthax08.gilliardcore.handlers.CustomChatHandler;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    private static Main instance;
    public static Economy econ;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        instance = this;
        econ = EconomyBuilder.build();
        String prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("settings.console-prefix"));
        Logger logger = getServer().getLogger();
        logger.info(prefix + " Initializing...");
        logger.info(prefix + " Initializing Commands...");
        try {
            //TODO: Command Initialization
            getCommand("verify").setExecutor(new VerifyCommand());
        } catch (Exception e) {
            logger.severe(prefix + " There was an error initializing commands. Please message CarThax08.");
            getServer().getPluginManager().disablePlugin(this);
        }
        logger.info(prefix + " Initializing Event Handlers...");
        try {
            //TODO: Event Initialization
            getServer().getPluginManager().registerEvents(new CustomChatHandler(), this);
        } catch (Exception e) {
            logger.severe(prefix + " There was an error initializing events. Please message CarThax08.");
            getServer().getPluginManager().disablePlugin(this);
        }
        try {
            BotMain.initBot();
        } catch (Exception e) {
            logger.warning(prefix + " There was an error initializing the discord bot. Please message CarThax08.");
        }
    }

    @Override
    public void onDisable() {
        if (BotMain.isRunning)
            BotMain.shutdown();
        // Plugin shutdown logic
    }

    public static FileConfiguration getConfigObj() {
        return instance.getConfig();
    }

    public static Main getInstance() {
        return instance;
    }
}
