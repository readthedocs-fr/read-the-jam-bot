package fr.lukam.jambot.model;

public class GuildId {

    public final long id;

    public GuildId(long id) {
        this.id = id;
    }

    public GuildId(String id) {
        this.id = Long.parseLong(id);
    }

}
