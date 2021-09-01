package com.github.carthax08.gilliardcore.discord.jda.bot;

import com.github.carthax08.gilliardcore.Main;
import com.github.carthax08.gilliardcore.util.DataStore;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.ChatColor;

import javax.security.auth.login.LoginException;

public class BotMain extends ListenerAdapter {
    public static boolean isRunning = false;
    static JDA jda = null;

    public static void initBot() throws LoginException {
        jda = JDABuilder.createDefault(Main.getConfigObj().getString("discord-bot-settings.bot-token")).build();
        jda.addEventListener(new BotMain());
        if(jda != null){
            isRunning = true;
        }
    }

    public static void shutdown() {
        jda.shutdown();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.TEXT))
        {
            if(event.getMessage().getContentRaw().contains("/verify")) {
                if(DataStore.playerVerifyDataMap.containsKey(event.getMessage().getContentRaw().replace("/verify", "").replace(" ", ""))) {
                    event.getChannel().sendMessage("Test Worked!").queue();
                    event.getGuild().addRoleToMember(event.getMessage().getMember(), event.getGuild().getRoleById(Main.getConfigObj().getString("discord-bot-settings.verified-role-id"))).queue();
                    DataStore.playerVerifyDataMap.get(event.getMessage().getContentRaw().replace("/verify", "").replace(" ", "")).sendMessage(ChatColor.GREEN + "Successfully verified discord user: " + event.getMessage().getMember().getUser().getAsTag());
                    DataStore.playerVerifyDataMap.remove(event.getMessage().getContentRaw().replace("/verify", "").replace(" ", ""));
                }
            }
        }
    }
}
