package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.Command;
import fr.lukam.jambot.model.Channels;
import fr.lukam.jambot.model.Limit;
import fr.lukam.jambot.model.Theme;
import fr.lukam.jambot.model.Themes;
import fr.lukam.jambot.utils.ConfigurationUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandPropose extends Command {

    private final Channels channels;
    private final Limit limit;

    public CommandPropose() {
        this.channels = ConfigurationUtils.getChannels();
        this.limit = ConfigurationUtils.getLimit();
    }

    @Override
    public boolean canExecute(GuildMessageReceivedEvent event) {
        return true;
    }

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        if (event.getMessage().getContentDisplay().trim().length() == 8) {
            event.getChannel().sendMessage("Vous devez précisez un thème.").queue();
            return;
        }

        if (!event.getMessage().getMentionedRoles().isEmpty()
                || !event.getMessage().getMentionedMembers().isEmpty()
                || !event.getMessage().getMentionedChannels().isEmpty()) {
            event.getChannel().sendMessage("Vous ne pouvez pas mentionner quelque chose dans un thème.").queue();
            return;
        }

        if (!channels.isAuthorized(event.getChannel().getIdLong())) {
            event.getChannel().sendMessage("Vous ne pouvez pas faire cette action ici.").queue();
            return;
        }

        Themes themes = retrieveThemes();

        String content = event.getMessage().getContentDisplay();
        String theme = content.substring(content.indexOf(" ") + 1).trim();

        if (theme.contains("http")) {
            event.getChannel().sendMessage("Vous ne pouvez pas mettre de lien dans un thème.").queue();
            return;
        }

        if (theme.length() > limit.limit()) {
            event.getChannel().sendMessage("Ce thème est trop long.").queue();
            return;
        }

        if (theme.contains("`")
                || theme.contains("*")
                || theme.contains("_")
                || theme.contains("|")
                || theme.contains("\\")) {
            event.getChannel().sendMessage("Vous ne pouvez pas mettre de caractère spécial dans un thème.").queue();
            return;
        }

        themes.add(new Theme(theme));

        registerThemes(themes);

        event.getChannel().sendMessage("La proposition a bien été enregistrée.").queue();
    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("propose");
    }

}
