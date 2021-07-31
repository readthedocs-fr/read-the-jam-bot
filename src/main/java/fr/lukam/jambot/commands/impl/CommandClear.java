package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.StaffCommand;
import fr.lukam.jambot.model.Themes;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandClear extends StaffCommand {

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        Themes themes = retrieveThemes();
        themes.clear();
        registerThemes(themes);

        event.getChannel().sendMessage("Les thèmes ont bien été supprimés.").queue();

    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("clear");
    }

}
