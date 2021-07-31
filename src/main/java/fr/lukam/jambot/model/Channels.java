package fr.lukam.jambot.model;

import java.util.List;

public class Channels {

    private final List<String> channels;

    public Channels(List<String> authorized) {
        this.channels = authorized;
    }

    public boolean isAuthorized(String id) {
        return channels.contains(id);
    }

    public boolean isAuthorized(long id) {
        return channels.contains(String.valueOf(id));
    }

}
