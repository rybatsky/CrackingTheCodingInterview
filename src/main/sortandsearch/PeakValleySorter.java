package sortandsearch;

import java.util.Arrays;

//10.11 (30min)
public class PeakValleySorter {

    public static void sort(int[] array) {
        Arrays.sort(array);
        for (int i = 1; i < array.length; i += 2) {
            int temp = array[i - 1];
            array[i - 1] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 1, 2, 3, 7, 10, 15, 4, 32, 6, 44};
        sort(array);
        StringBuilder sb = new StringBuilder();
        for (int v : array) {
            sb.append(v).append(", ");
        }
        System.out.println(sb.toString().substring(0, sb.length() - 2));
    }
}
