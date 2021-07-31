package fr.lukam.jambot.listeners;

import fr.lukam.jambot.commands.Command;
import fr.lukam.jambot.commands.CommandsRepository;
import fr.lukam.jambot.model.Prefix;
import fr.lukam.jambot.utils.ConfigurationUtils;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter {

    private final CommandsRepository commandsRepository;
    private final Prefix prefix;
    private final long guildId;

    public CommandListener(CommandsRepository commandsRepository, Prefix prefix) {
        this.commandsRepository = commandsRepository;
        this.prefix = prefix;
        this.guildId = ConfigurationUtils.getGuildId().id;
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        if (event.getGuild().getIdLong() != guildId) {
            return;
        }

        String content = event.getMessage().getContentRaw();

        if (content.isEmpty()) {
            return;
        }

        if (content.charAt(0) != prefix.prefix) {
            return;
        }

        String[] args = content.substring(1).split(" ");

        if (args.length == 0) {
            args = new String[]{" "};
        }

        Command command = this.commandsRepository.getCommandByName(args[0]);

        if (command.canExecute(event)) {
            command.execute(event);
            return;
        }

        event.getChannel().sendMessage("Vous ne pouvez pas exécuter cette commande.").queue();
    }

}
