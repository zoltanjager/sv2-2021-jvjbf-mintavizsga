package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> getUniqueChars(String text) {
        List<Character> result = new ArrayList<>();

        if (text == null) {
            throw new IllegalArgumentException("Text is null.");
        } else if (text.length() == 1) {
            result.add(text.charAt(0));
        } else {
            result = findUniqueChars(text);
        }
        return result;
    }

    private List<Character> findUniqueChars(String text) {
        List<Character> result = new ArrayList<>();

        result.add(text.charAt(0));
        for (char actual : text.toCharArray()) {
            if (!result.contains(actual)) {
                result.add(actual);
            }
        }
        return result;
    }
}
