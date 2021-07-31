package fr.lukam.jambot;

import fr.lukam.jambot.commands.CommandsRepository;
import fr.lukam.jambot.listeners.CommandListener;
import fr.lukam.jambot.model.Prefix;
import fr.lukam.jambot.utils.ConfigurationUtils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    private static JDA jda = null;

    public static void main(String[] args) {

        if (!buildJDA()) {
            return;
        }

        startBotLoop();
    }

    private static boolean buildJDA() {

        Prefix prefix = ConfigurationUtils.getPrefix();

        try {

            System.out.println(ConfigurationUtils.getToken().token);
            jda = JDABuilder.createDefault(ConfigurationUtils.getToken().token)
                    .setStatus(OnlineStatus.ONLINE)
                    .setActivity(Activity.of(Activity.ActivityType.DEFAULT, "préfixe : " + prefix.prefix))
                    .addEventListeners(new CommandListener(new CommandsRepository(), prefix))
                    .build();

        } catch (LoginException e) {
            e.printStackTrace();
        }

        if (jda == null) {
            LOGGER.error("Error while launching JamBot");
            return false;
        }

        LOGGER.info("JamBot started successfully");
        return true;
    }

    private static void startBotLoop() {

        String nextLine;

        do {
            nextLine = SCANNER.nextLine();
            LOGGER.info("Write \"stop\" to stop JamBot");
        } while (!nextLine.equalsIgnoreCase("stop"));

        jda.shutdown();
        LOGGER.info("JamBot is stopped");

        if (nextLine.equalsIgnoreCase("stop")) {
            System.exit(0);
        }

    }

}
