package fr.lukam.jambot.model;

import java.util.List;

public record Channels(List<String> channels) {
    public boolean isAuthorized(String id) {
        return channels.contains(id);
    }

    public boolean isAuthorized(long id) {
        return channels.contains(String.valueOf(id));
    }

}
