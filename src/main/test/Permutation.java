package test;

import java.util.HashSet;
import java.util.Set;


//Task 2. O(n^2)
public class Permutation {

    public static Set<StringBuilder> permute(int[] arr) {
        Set<StringBuilder> perms = new HashSet<>();
        permute(arr, 0, perms);
        return perms;
    }

    private static void permute(int[] arr, int index, Set<StringBuilder> perms) {
        StringBuilder perm = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            perm.append(arr[i]);
        }
        if (arr.length > 0) {
            perm.append(arr[arr.length - 1]);
        }
        perms.add(perm);
        for (int i = index; i < arr.length; i++) {
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;

            permute(arr, index + 1, perms);

            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(permute(arr));
    }
}
