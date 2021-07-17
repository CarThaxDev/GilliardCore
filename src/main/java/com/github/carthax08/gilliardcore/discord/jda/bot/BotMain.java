package com.github.carthax08.gilliardcore.discord.jda.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class BotMain extends ListenerAdapter {

    public static void initBot() throws LoginException {
        JDA jda = JDABuilder.createDefault("BOT_TOKEN_HERE").build();
        jda.addEventListener(new BotMain());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.isFromType(ChannelType.TEXT))
        {
            if(event.getMessage().getContentRaw().contains("/verify"))
            event.getChannel().sendMessage("Test Worked!").queue();
        }
    }
}
