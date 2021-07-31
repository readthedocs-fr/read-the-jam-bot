package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.Command;
import fr.lukam.jambot.model.Channels;
import fr.lukam.jambot.model.Theme;
import fr.lukam.jambot.model.Themes;
import fr.lukam.jambot.utils.ConfigurationUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandPropose extends Command {

    private final Channels channels;

    public CommandPropose() {
        this.channels = ConfigurationUtils.getChannels();
    }

    @Override
    public boolean canExecute(GuildMessageReceivedEvent event) {
        return true;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        if (channels.isAuthorized(event.getChannel().getIdLong())) {
            event.getChannel().sendMessage("Vous ne pouvez pas faire cette action ici.").queue();
            return;
        }

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
