package fr.lukam.jambot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SerializerUtils {

    private static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    private SerializerUtils() {}

    public static String serialize(Object object) {
        return GSON.toJson(object);
    }

    public static <T> T deserialize(File file, Class<T> target) throws IOException {
        return GSON.fromJson(loadContent(file), target);
    }

    private static String loadContent(File file) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        reader.close();
        return builder.toString();
    }

}
