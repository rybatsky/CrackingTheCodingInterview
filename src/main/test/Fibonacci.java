package test;

//Task 2. O(n)
public class Fibonacci {

    public static boolean isFib(String seq) {
        int i = 0;
        int step = 1;

        while (i <= seq.length() - 3 * step) {
            int cur = subint(seq, i, i + step);
            int next = subint(seq, i + step, i + 2 * step);
            int sum = subint(seq, i + 2 * step, i + 3 * step);
            int next2 = subint(seq, i + step, i + 2 * step + 1);

            if (cur + next == sum) {
                if (i + 3 * step == seq.length()) {
                    return true;
                }
                i += step;
            } else if (i <= seq.length() - 3 * step - 2 &&
                    cur + next2 == subint(seq, i + 2 * step + 1, i + 3 * step + 2)) {
                if (i + 3 * step + 2 == seq.length()) {
                    return true;
                }
                step++;
                i += step;
            } else if (i <= seq.length() -  3 * step - 1 &&
                    cur + next == subint(seq, i + 2 * step, i + 3 * step + 1)) {
                if (i + 3 * step + 1 == seq.length()) {
                    return true;
                }
                i += step;
                step++;
            } else {
                i = 0;
                step++;
            }
        }
        return false;
    }

    public static int subint(String str, int start, int end) {
        return Integer.parseInt(str.substring(start, end));
    }

    public static void main(String[] args) {
        String example = "1234";
        String example2 = "1235";
        String example3 = "13213455";
        String example4 = "13213457";
        String example5 = "377610987";
        String example6 = "377610988";
        String example7 = "5813";
        String example8 = "81321";
        String example9 = "81322";
        String example10 = "67651094617711";
        String example11 = "676510946177110";
        System.out.println(isFib(example)); //false
        System.out.println(isFib(example2)); //true
        System.out.println(isFib(example3)); //true
        System.out.println(isFib(example4)); //false
        System.out.println(isFib(example5)); //true
        System.out.println(isFib(example6)); //false
        System.out.println(isFib(example7)); //true
        System.out.println(isFib(example8)); //true
        System.out.println(isFib(example9)); //false
        System.out.println(isFib(example10)); //true
        System.out.println(isFib(example11)); //false
    }
}
