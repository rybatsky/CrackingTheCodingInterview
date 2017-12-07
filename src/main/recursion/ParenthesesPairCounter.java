package recursion;

import java.util.HashSet;
import java.util.Set;

//8.9 (30min)
public class ParenthesesPairCounter {

    public static Set<String> generateParentheses(int parCount) {
        Set<String> set = new HashSet<>();
        if (parCount == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParentheses(parCount - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        set.add(str.substring(0, i + 1) + "()" + str.substring(i + 1, str.length()));
                    }
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Set<String> list = generateParentheses(3);
        int i = 0;
        for (String s : list) {
            i++;
            System.out.println(i + ": " + s);
        }
    }
}
