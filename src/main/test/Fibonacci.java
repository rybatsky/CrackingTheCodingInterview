package test;

import java.util.ArrayList;
import java.util.List;

//Task 2. O(n)
public class Fibonacci {

    public static int max(int[] array) {
        int maximum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maximum < array[i]) {
                maximum = array[i];
            }
        }
        return maximum;
    }

    public static List<Integer> fib(int max) {
        List<Integer> fib = new ArrayList<>();
        if (max == 0) {
            fib.add(0);
            return fib;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        fib.add(a);
        fib.add(b);
        while (c < max) {
            c = a + b;
            a = b;
            b = c;
            fib.add(c);
        }
        return fib;
    }

    public static boolean isFib(int[] array) {
        List<Integer> fib = fib(max(array));
        for (int i = 0; i < array.length; i++) {
            if (!fib.contains(array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 2, 3, 5};
        int[] array2 = {1, 2, 3};
        int[] array3 = {2, 2, 3, 5};
        int[] array4 = {2, 2, 3, 5, 7};

        System.out.println(isFib(array));
        System.out.println(isFib(array2));
        System.out.println(isFib(array3));
        System.out.println(isFib(array4));

    }
}
