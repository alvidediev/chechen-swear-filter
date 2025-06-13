package by.dediev.chechenswearfilter;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChechenSwearFilterImpl implements ChechenSwearFilter {
    private Set<String> words = new HashSet<>();

    public ChechenSwearFilterImpl() {
        ClassLoader classLoader = getClass().getClassLoader();
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
            words = new HashSet<>(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean containsSwear(String text) {
        return words.contains(text);
    }

    @Override
    public String censorTest(String text) {
        return "";
    }
}
