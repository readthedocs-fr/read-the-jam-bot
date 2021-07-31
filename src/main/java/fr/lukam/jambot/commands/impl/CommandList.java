package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandList extends Command {

    @Override
    public boolean canExecute(GuildMessageReceivedEvent event) {
        return true;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {
        retrieveThemes().buildMessage().forEach(message -> event.getChannel().sendMessage(message).queue());
    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("list");
    }

}
