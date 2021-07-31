package fr.lukam.jambot.model;

public class RoleId {

    public final long id;

    public RoleId(long id) {
        this.id = id;
    }

    public RoleId(String id) {
        this.id = Long.parseLong(id);
    }

}
