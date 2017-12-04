package arrays;

//1.2
public class PermutationChecker {

    public boolean isPermutation(String s1, String s2) {
        int strLength1 = s1.length();
        int strLength2 = s2.length();
        if (strLength1 != strLength2) {
            return false;
        }

        int[] symbols = new int[256]; //ASCII
        for (char c : s1.toCharArray()) {
            symbols[c]++;
        }

        for (int i = 0; i < strLength1; i++) {
            int c = s2.charAt(i);
            symbols[c]--;
            if (symbols[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PermutationChecker ps = new PermutationChecker();
        System.out.println(ps.isPermutation("sasasasas", ""));
        System.out.println(ps.isPermutation("", ""));
        System.out.println(ps.isPermutation("", "nan"));
        System.out.println(ps.isPermutation("sas", "nan"));
        System.out.println(ps.isPermutation("sas", "ass"));
    }
}
