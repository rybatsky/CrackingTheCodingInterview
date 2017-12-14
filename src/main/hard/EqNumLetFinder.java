package hard;

//17.5 (60min)
public class EqNumLetFinder {

    public static char[] subArray(char[] array, int start, int end) {
        if (start > end) return null;
        char[] subArr = new char[end - start + 1];
        for (int i = start; i <= end; i++) {
            subArr[i - start] = array[i];
        }
        return subArr;
    }

    public static boolean equalNumbersLetters(char[] array, int start, int end) {
        int counter = 0;
        for (int i = start; i <= end; i++) {
            if (Character.isLetter(array[i])) {
                counter++;
            } else if (Character.isDigit(array[i])) {
                counter--;
            }
        }
        return counter == 0;
    }

    public static char[] longestSubArray(char[] array) {
        for (int len = array.length; len > 1; len--) {
            for (int i = 0; i <= array.length - len; i++) {
                if (equalNumbersLetters(array, i, i + len - 1)) {
                    return subArray(array, i, i + len - 1);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        char a = 'a';
        char one = '1';
        char[] array = {a, one, one, a, a, a, a, one, one, one, a, one, one, one, one, one, a, a, a, a, a, a, a, one};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        char[] max = longestSubArray(array);
        if (max != null) {
            System.out.print("\n" + max.length + ": ");
            for (int i = 0; i < max.length; i++) {
                System.out.print(max[i] + " ");
            }
        }
    }
}
