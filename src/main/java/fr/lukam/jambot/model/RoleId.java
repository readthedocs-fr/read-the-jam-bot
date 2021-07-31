package fr.lukam.jambot.model;

public record RoleId(long id) {
    public RoleId(String id) {
        this(Long.parseLong(id));
    }

}
