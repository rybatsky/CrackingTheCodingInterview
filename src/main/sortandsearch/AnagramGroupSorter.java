package sortandsearch;

import java.util.Arrays;
import java.util.Comparator;

//10.2 (30min)
public class AnagramGroupSorter {
    static class AnagramComparator implements Comparator<String> {
        private String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public static void main(String[] args) {
        String[] array = {"abba", "acc", "acdc", "baab", "cac", "dcac", "aaa", "bbbbbb"};
        Arrays.sort(array, new AnagramComparator());
        StringBuilder sb = new StringBuilder();
        for (String v : array) {
            sb.append(v).append(", ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 2));
    }
}
