package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.StaffCommand;
import fr.lukam.jambot.model.Theme;
import fr.lukam.jambot.model.Themes;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandChoose extends StaffCommand {

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        Themes themes = retrieveThemes();
        Theme theme = themes.getRandomTheme();
        event.getChannel().sendMessage("La Game jam aura lieu sur le thème suivant : " + theme.theme()).queue();

    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("choose");
    }

}
