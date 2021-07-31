package fr.lukam.jambot.model;

import java.util.*;

public class Themes {

    private static final Random RANDOM = new Random();

    private final List<Theme> themes;

    public Themes(List<Theme> themes) {
        this.themes = themes;
    }

    public Themes() {
        this.themes = new ArrayList<>();
    }

    public List<Theme> getThemes() {
        return new ArrayList<>(themes);
    }

    public void add(Theme theme) {
        if (themes.contains(theme)) {
            return;
        }
        themes.add(theme);
    }

    public void remove(Theme theme) {
        this.themes.remove(theme);
    }

    public Theme getRandomTheme() {
        return themes.get(RANDOM.nextInt(themes.size()));
    }

}
