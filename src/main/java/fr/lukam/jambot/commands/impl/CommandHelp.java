package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandHelp extends Command {

    @Override
    public boolean canExecute(GuildMessageReceivedEvent event) {
        return true;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        event.getChannel().sendMessage("list : voir les propositions\n"
                + "propose : proposer un thème\n"
                + "remove : supprimer un thème").queue();

    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("help");
    }

}
