package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.Command;
import fr.lukam.jambot.model.Theme;
import fr.lukam.jambot.model.Themes;
import fr.lukam.jambot.utils.SerializerUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class CommandPropose extends Command {

    @Override
    public boolean canExecute(GuildMessageReceivedEvent event) {
        return true;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        Themes themes = retrieveThemes();

        String content = event.getMessage().getContentDisplay();
        themes.add(new Theme(content.substring(content.indexOf(" ") + 1).trim()));

        registerThemes(themes);

        event.getChannel().sendMessage("La proposition a bien été enregistrée.").queue();
    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("propose");
    }

}
