package fr.lukam.jambot.utils;

import com.electronwill.nightconfig.core.file.FileConfig;
import fr.lukam.jambot.model.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ConfigurationUtils {

    private static final String TOKEN_PATH = "token";
    private static final String TOKEN_DEFAULT = "token";

    private static final String PREFIX_PATH = "prefix";
    private static final String PREFIX_DEFAULT = "*";

    private static final String GUILD_PATH = "guild";
    private static final String GUILD_DEFAULT = "803180065277712404";

    private static final String ROLE_PATH = "role";
    private static final String ROLE_DEFAULT = "855906711448555242L";

    private static final String AUTHORIZED_PATH = "authorized";
    private static final List<String> AUTHORIZED_DEFAULT = Arrays.asList("855906711448555242", "855906711448555242");

    private static final String CHANNELS_PATH = "channels";
    private static final List<String> CHANNELS_DEFAULT = Arrays.asList("855906711448555242", "855906711448555242");

    public static Token getToken() {

        File file = new File("configuration.toml");

        if (!file.exists()) {
            return new Token(TOKEN_DEFAULT);
        }

        FileConfig fileConfig = FileConfig.of(file);
        fileConfig.load();
        String token = fileConfig.getOrElse(TOKEN_PATH, TOKEN_DEFAULT);
        fileConfig.close();
        return new Token(token);
    }

    public static Prefix getPrefix() {

        File file = new File("configuration.toml");

        if (!file.exists()) {
            return new Prefix(PREFIX_DEFAULT.charAt(0));
        }

        FileConfig fileConfig = FileConfig.of(file);
        fileConfig.load();
        char prefix = fileConfig.getOrElse(PREFIX_PATH, PREFIX_DEFAULT).charAt(0);
        fileConfig.close();
        return new Prefix(prefix);
    }

    public static GuildId getGuildId() {

        File file = new File("configuration.toml");

        if (!file.exists()) {
            return new GuildId(GUILD_DEFAULT);
        }

        FileConfig fileConfig = FileConfig.of(file);
        fileConfig.load();
        String guildId = fileConfig.getOrElse(GUILD_PATH, GUILD_DEFAULT);
        fileConfig.close();
        return new GuildId(guildId);
    }

    public static RoleId getRoleID() {

        File file = new File("configuration.toml");

        if (!file.exists()) {
            return new RoleId(GUILD_DEFAULT);
        }

        FileConfig fileConfig = FileConfig.of(file);
        fileConfig.load();
        String roleId = fileConfig.getOrElse(ROLE_PATH, ROLE_DEFAULT);
        fileConfig.close();
        return new RoleId(roleId);
    }

    public static Authorized getAuthorized() {

        File file = new File("configuration.toml");

        if (!file.exists()) {
            return new Authorized(AUTHORIZED_DEFAULT);
        }

        FileConfig fileConfig = FileConfig.of(file);
        fileConfig.load();
        List<String> authorized = fileConfig.getOrElse(AUTHORIZED_PATH, AUTHORIZED_DEFAULT);
        fileConfig.close();
        return new Authorized(authorized);
    }

    public static Channels getChannels() {

        File file = new File("configuration.toml");

        if (!file.exists()) {
            return new Channels(CHANNELS_DEFAULT);
        }

        FileConfig fileConfig = FileConfig.of(file);
        fileConfig.load();
        List<String> channels = fileConfig.getOrElse(CHANNELS_PATH, CHANNELS_DEFAULT);
        fileConfig.close();
        return new Channels(channels);
    }

}
