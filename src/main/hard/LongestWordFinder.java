package hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static moderatedifficulty.task1620.Words.getWords;

//17.15 (60min)
public class LongestWordFinder {
    private static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() < o2.length()) return 1;
            if (o1.length() > o2.length()) return -1;
            return 0;
        }
    }

    public static String longestWord(String arr[]) {
        Map<String, Boolean> map = new HashMap<>();
        for (String str : arr) {
            map.put(str, true);
        }

        Arrays.sort(arr, new LengthComparator());
        for (String s : arr) {
            if (containWords(s, true, map)) {
                System.out.println(s);
                return s;
            }
        }
        return "";
    }

    public static boolean containWords(String str, boolean isOriginalWord, Map<String, Boolean> map) {
        if (map.containsKey(str) && !isOriginalWord) {
            return map.get(str);
        }

        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if (map.containsKey(left) && map.get(left) &&
                    containWords(right, false, map)) {
                return true;
            }
        }
        map.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        longestWord(getWords());
    }
}
