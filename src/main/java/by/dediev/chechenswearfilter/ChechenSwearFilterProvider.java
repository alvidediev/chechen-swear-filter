package by.dediev.chechenswearfilter;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChechenSwearFilterProvider {
    private static final Set<String> words = loadWords();

    private static Set<String> loadWords() {
        ClassLoader classLoader = ChechenSwearFilterProvider.class.getClassLoader();
        String filePath = "swear_words.txt";
        try (InputStream inputStream = classLoader.getResourceAsStream(filePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + filePath);
            }
            List<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .filter(s -> !s.isEmpty())
                    .toList();
            return new HashSet<>(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Set<String> getWords() {
        return words;
    }
}
