package test;

import java.util.HashSet;
import java.util.Iterator;

//Task 2. O(n)
public class Permutation {

    public static HashSet<Pair> pairing(int[] array) {
        HashSet<Pair> pairs = new HashSet<>();
        HashSet<Integer> permuted = permute(array);
        Iterator<Integer> it = permuted.iterator();
        while (it.hasNext()) {
            int itt = it.next();
            int iterr;
            for (int n = 2; n < 10; n++) {
                if (itt % n == 0) {
                    iterr = itt / n;
                    if (permuted.contains(iterr)) {
                        pairs.add(new Pair(itt, iterr));
                    }
                }
            }
        }
        return pairs;
    }

    public static HashSet<Integer> permute(int[] arr) {
        HashSet<Integer> perms = new HashSet<>();
        permute(arr, 0, perms);
        return perms;
    }

    private static void permute(int[] arr, int index, HashSet<Integer> perms) {
        StringBuilder perm = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            perm.append(arr[i]);
        }
        if (arr.length > 0) {
            perm.append(arr[arr.length - 1]);
        }
        perms.add(Integer.valueOf(perm.toString()));
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
        System.out.println(pairing(arr));
    }
}
