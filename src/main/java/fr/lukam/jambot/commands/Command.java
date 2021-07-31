package fr.lukam.jambot.commands;

import fr.lukam.jambot.model.Themes;
import fr.lukam.jambot.utils.SerializerUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Command {

    abstract public boolean canExecute(GuildMessageReceivedEvent event);

    abstract public void execute(GuildMessageReceivedEvent event);

    abstract public boolean is(String name);

    protected Themes retrieveThemes() {

        try {
            File file = new File("themes.json");

            if (!file.exists()) {
                return new Themes();
            }

            return SerializerUtils.deserialize(file, Themes.class);

        } catch (IOException e) {
            e.printStackTrace();
            return new Themes();
        }

    }

    protected void registerThemes(Themes themes) {

        try {
            File file = new File("themes.json");

            if (!file.exists()) {
                return;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(SerializerUtils.serialize(themes));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
