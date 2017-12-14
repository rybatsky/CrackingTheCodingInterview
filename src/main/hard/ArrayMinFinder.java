package hard;

import java.util.Arrays;

//17.14 (40min)
public class ArrayMinFinder {
    public static int[] smallestK(int[] array, int k) {
        if (k <= 0 || k > array.length) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(array);

        int[] smallest = new int[k];
        System.arraycopy(array, 0, smallest, 0, k);
        return smallest;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 44, 9, 1, 11, 6, 22, 15};
        int[] smallest = smallestK(array, 5);

        StringBuilder sb = new StringBuilder();
        for (int v : smallest) {
            sb.append(v).append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
