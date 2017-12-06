package array;

//1.4
public class PalindromeChecker {

    public static boolean isPermutatedPalindrome(String str) {
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

        return i <= 1;
    }

    public static void main(String[] args) {
        System.out.println(isPermutatedPalindrome(""));
        System.out.println(isPermutatedPalindrome("sas"));
        System.out.println(isPermutatedPalindrome("saas"));
        System.out.println(isPermutatedPalindrome("sdsf"));
        System.out.println(isPermutatedPalindrome("seres"));
        System.out.println(isPermutatedPalindrome("resp"));
        System.out.println(isPermutatedPalindrome("pepepepep"));
        System.out.println(isPermutatedPalindrome("epepepe"));
        System.out.println(isPermutatedPalindrome("sa s"));
    }
}
