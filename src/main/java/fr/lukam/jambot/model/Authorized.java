package fr.lukam.jambot.model;

import java.util.List;

public class Authorized {

    private final List<String> authorized;

    public Authorized(List<String> authorized) {
        this.authorized = authorized;
    }

    public boolean isAuthorized(String id) {
        return authorized.contains(id);
    }

    public boolean isAuthorized(long id) {
        return authorized.contains(String.valueOf(id));
    }

}
