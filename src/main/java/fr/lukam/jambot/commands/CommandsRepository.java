package fr.lukam.jambot.commands;

import fr.lukam.jambot.commands.impl.*;

import java.util.Arrays;
import java.util.List;

public class CommandsRepository {

    private final List<Command> commands;
    private final Command defaultCommand = new DefaultCommand();

    public CommandsRepository() {
        commands = Arrays.asList(
                new CommandPropose(),
                new CommandList(),
                new CommandRemove(),
                new CommandChoose(),
                new CommandHelp()
        );
    }

    public Command getCommandByName(String name) {
        return commands.stream().filter(command -> command.is(name)).findFirst().orElse(this.defaultCommand);
    }

}
