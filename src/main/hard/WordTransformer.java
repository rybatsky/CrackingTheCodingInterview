package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import static moderatedifficulty.task1620.Words.getWords;

//17.22 (60min)
public class WordTransformer {

    public static ArrayList<String> wordsOneAway(String word) {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String w = word.substring(0, i) + c + word.substring(i + 1);
                words.add(w);
            }
        }
        return words;
    }

    public static LinkedList<String> transform(HashSet<String> visited, String startWord, String stopWord, Set<String> dictionary) {
        if (startWord.equals(stopWord)) {
            LinkedList<String> path = new LinkedList<>();
            path.add(startWord);
            return path;
        } else if (visited.contains(startWord) || !dictionary.contains(startWord)) {
            return null;
        }

        visited.add(startWord);
        ArrayList<String> words = wordsOneAway(startWord);

        for (String word : words) {
            LinkedList<String> path = transform(visited, word, stopWord, dictionary);
            if (path != null) {
                path.addFirst(startWord);
                return path;
            }
        }

        return null;
    }

    public static LinkedList<String> transform(String start, String stop, String[] words) {
        HashSet<String> dict = setupDictionary(words);
        HashSet<String> visited = new HashSet<>();
        return transform(visited, start, stop, dict);
    }

    public static HashSet<String> setupDictionary(String[] words) {
        HashSet<String> hash = new HashSet<>();
        for (String word : words) {
            hash.add(word.toLowerCase());
        }
        return hash;
    }

    public static void main(String[] args) {
        LinkedList<String> list = transform("damp", "like", getWords());

        if (list == null) {
            System.out.println("No path.");
        } else {
            System.out.println(list.toString());
        }
    }
}
