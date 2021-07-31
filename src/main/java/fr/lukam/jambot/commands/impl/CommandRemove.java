package fr.lukam.jambot.commands.impl;

import fr.lukam.jambot.commands.StaffCommand;
import fr.lukam.jambot.model.Theme;
import fr.lukam.jambot.model.Themes;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class CommandRemove extends StaffCommand {

    @Override
    public void execute(GuildMessageReceivedEvent event) {

        String content = event.getMessage().getContentRaw();
        Theme theme = new Theme(content.substring(content.indexOf(" ") + 1));

        Themes themes = retrieveThemes();

        if (!themes.contains(theme)) {
            event.getChannel().sendMessage("Ce thème n'existe pas <:shrugenough:633064791425941565>.").queue();
            return;
        }

        themes.remove(theme);
        registerThemes(themes);

        event.getChannel().sendMessage("Le thème a bien été supprimé.").queue();
    }

    @Override
    public boolean is(String name) {
        return name.equalsIgnoreCase("remove");
    }

}
