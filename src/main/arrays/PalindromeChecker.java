package arrays;

//1.4
public class PalindromeChecker {

    public boolean isPermutatedPalindrome(String str) {
        int[] symbols = new int[256]; //ASCII
        char[] letters = str.replace(" ", "").toCharArray();
        for (char c : letters) {
            symbols[c]++;
        }

        int i = 0;
        for (char c : letters) {
            if (symbols[c] % 2 != 0) {
                i++;
            }
        }

        if (i > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker();
        System.out.println(pc.isPermutatedPalindrome(""));
        System.out.println(pc.isPermutatedPalindrome("sas"));
        System.out.println(pc.isPermutatedPalindrome("saas"));
        System.out.println(pc.isPermutatedPalindrome("sdsf"));
        System.out.println(pc.isPermutatedPalindrome("seres"));
        System.out.println(pc.isPermutatedPalindrome("resp"));
        System.out.println(pc.isPermutatedPalindrome("pepepepep"));
        System.out.println(pc.isPermutatedPalindrome("epepepe"));
        System.out.println(pc.isPermutatedPalindrome("sa s"));
    }
}
