package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.StaffCommand;
import fr.lukam.jambot.model.Themes;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandList extends StaffCommand {

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        Themes themes = retrieveThemes();

        StringBuilder message = new StringBuilder("Liste des thèmes :\n");

        for (int i = 0; i < themes.getThemes().size(); i++) {
            message.append(i + 1)
                    .append(" - ")
                    .append(themes.getThemes().get(i).theme)
                    .append("\n");
        }

        event.getChannel().sendMessage(message).queue();
    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("list");
    }

}
