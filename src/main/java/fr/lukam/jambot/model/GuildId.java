package fr.lukam.jambot.model;

public record GuildId(long id) {
    public GuildId(String id) {
        this(Long.parseLong(id));
    }

}
