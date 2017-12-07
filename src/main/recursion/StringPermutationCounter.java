package recursion;

import java.util.ArrayList;

//8.7 (40min)
public class StringPermutationCounter {
    public static ArrayList<String> getPermutations(String str) {
        if (str == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = getPermutations(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                permutations.add(word.substring(0, j) + first + word.substring(j));
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPermutations("string");
        for (String s : list) {
            System.out.println(list.indexOf(s) + 1 + ": " + s);
        }
    }
}
