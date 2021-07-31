package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class DefaultCommand extends Command {

    @Override
    public boolean canExecute(GuildMessageReceivedEvent event) {
        return true;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {

    }

    @Override
    public boolean is(String name) {
        return true;
    }

}
