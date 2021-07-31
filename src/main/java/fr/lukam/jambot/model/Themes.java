package fr.lukam.jambot.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Themes {

    private final Set<Theme> themes;

    public Themes(Set<Theme> themes) {
        this.themes = themes;
    }

    public Themes() {
        this.themes = new HashSet<>();
    }

    public List<Theme> getThemes() {
        return new ArrayList<>(themes);
    }

    public void add(Theme theme) {
        themes.add(theme);
    }

    public void remove(Theme theme) {
        this.themes.remove(theme);
    }

}
