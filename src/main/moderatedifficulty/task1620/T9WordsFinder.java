package moderatedifficulty.task1620;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static moderatedifficulty.task1620.Words.getWords;

//16.20 (60min)
public class T9WordsFinder {
    public static char[][] t9Letters = {
            null,
            null,
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static String convertToT9(String word, HashMap<Character, Character> letterToNumberMap) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (letterToNumberMap.containsKey(c)) {
                char digit = letterToNumberMap.get(c);
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public static HashMap<Character, Character> createLetterToNumberMap() {
        HashMap<Character, Character> letterToNumberMap = new HashMap<>();
        for (int i = 0; i < t9Letters.length; i++) {
            char[] letters = t9Letters[i];
            if (letters != null) {
                for (char letter : letters) {
                    char c = Character.forDigit(i, 10);
                    letterToNumberMap.put(letter, c);
                }
            }
        }
        return letterToNumberMap;
    }

    public static HashMap<String, List<String>> initializeDictionary(String[] words) {
        HashMap<Character, Character> letterToNumberMap = createLetterToNumberMap();

        HashMap<String, List<String>> wordsToNumbers = new HashMap<>();
        for (String word : words) {
            String numbers = convertToT9(word, letterToNumberMap);
            if (!wordsToNumbers.containsKey(numbers)) {
                wordsToNumbers.put(numbers, new ArrayList<>());
            }
            wordsToNumbers.get(numbers).add(word);
        }
        return wordsToNumbers;
    }

    public static List<String> getValidT9Words(String numbers, HashMap<String, List<String>> dictionary) {
        return dictionary.get(numbers);
    }

    public static void main(String[] args) {
        HashMap<String, List<String>> dictionary = initializeDictionary(getWords());
        List<String> words = getValidT9Words("8733", dictionary);
        for (String w : words) {
            System.out.println(w);
        }

    }
}
