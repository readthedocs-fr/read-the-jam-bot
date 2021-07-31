package fr.lukam.jambot.model;

import java.util.List;

public record Authorized(List<String> authorized) {
    public boolean isAuthorized(String id) {
        return authorized.contains(id);
    }

    public boolean isAuthorized(long id) {
        return authorized.contains(String.valueOf(id));
    }

}
