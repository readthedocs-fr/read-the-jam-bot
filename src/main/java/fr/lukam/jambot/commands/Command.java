package fr.lukam.jambot.commands;

import fr.lukam.jambot.commands.impl.CommandPropose;
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

public abstract class Command {

    abstract public boolean canExecute(GuildMessageReceivedEvent event);

    abstract public void execute(GuildMessageReceivedEvent event);

    abstract public boolean is(String name);

    protected Themes retrieveThemes() {

        try {

            URL resource = CommandPropose.class.getClassLoader().getResource("themes.json");

            if (resource == null) {
                return new Themes();
            }

            File file = new File(resource.toURI());
            return SerializerUtils.deserialize(file, Themes.class);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return new Themes();
        }

    }

    protected void registerThemes(Themes themes) {
        try {

            URL resource = CommandPropose.class.getClassLoader().getResource("themes.json");

            if (resource == null) {
                return;
            }

            File file = new File(resource.toURI());
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(SerializerUtils.serialize(themes));
            writer.close();

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

}
