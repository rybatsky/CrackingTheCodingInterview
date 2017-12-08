package test;

//Task 2. O(n)
public class Fibonacci {

    public static boolean isFib(int[] array) {
        for (int i = 2; i < array.length; i++) {
            if (array[i] != array[i - 1] + array[i - 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {0, 0, 1, 2, 3, 5};
        System.out.println(isFib(array));
        int[] array2 = {1, 2, 3};
        System.out.println(isFib(array2));
        int[] array3 = {2, 2, 3, 5};
        System.out.println(isFib(array3));
    }
}
