package fr.lukam.jambot.commands;

import fr.lukam.jambot.model.Themes;
import fr.lukam.jambot.utils.SerializerUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("themes.json"), StandardCharsets.UTF_8);
            writer.write(SerializerUtils.serialize(themes));
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
