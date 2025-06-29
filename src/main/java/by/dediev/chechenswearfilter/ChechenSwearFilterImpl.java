package by.dediev.chechenswearfilter;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ChechenSwearFilterImpl implements ChechenSwearFilter {

    private final Set<String> words = ChechenSwearFilterProvider.getWords();

    @Override
    public boolean containsSwear(String text) {
        List<String> listOfWordsFromText = cleanIncomingString(text);
        for (String word : listOfWordsFromText) {
            if (words.contains(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Очищает входящую строку (предложение) от знаков препинания
     * @param incomingString - входящая строка (предложение)
     * @return - новый массив содержащий только слова
     */
    private List<String> cleanIncomingString(String incomingString) {
        return Arrays.stream(incomingString.split("\\s+"))
                .map(string -> string.replaceAll("[^а-яА-Я0-9]", ""))
                .map(String::toLowerCase)
                .toList();
    }

    @Override
    public String censorText(String text) {
        String[] splitText = text.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitText.length; i++) {
            String word = splitText[i]
                    .toLowerCase()
                    .replaceAll("[^а-яА-Я0-9]", "");
            if (words.contains(word)) {
                sb.append("*".repeat(word.length()));
            } else {
                sb.append(splitText[i]);
            }
            if (i < splitText.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
