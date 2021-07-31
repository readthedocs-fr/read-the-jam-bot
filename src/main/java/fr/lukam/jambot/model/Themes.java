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

    public List<String> buildMessage() {
        List<String> messages = new ArrayList<>();
        StringBuilder message = new StringBuilder("Liste des thèmes :\n");

        for (int i = 0; i < themes.size(); i++) {
            if (i % 10 == 0) {
                messages.add(message.toString());
                message = new StringBuilder();
            }
            message.append(i + 1)
                    .append(" - ")
                    .append(themes.get(i).theme)
                    .append("\n");
        }

        messages.add(message.toString());
        return messages;
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

    public boolean contains(Theme theme) {
        return themes.contains(theme);
    }

    public void clear() {
        themes.clear();
    }

}
