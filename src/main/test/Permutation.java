package test;

import java.util.*;

//Task 2. O(n^2)
public class Permutation {

    public static List<Pair> pairing(int[] array) {
        List<Pair> pairs = new ArrayList<>();
        List<Integer> permuted = permute(array);
        Iterator<Integer> it = permuted.iterator();
        Iterator<Integer> iter = permuted.iterator();
        while (it.hasNext()) {
            int itt = it.next();
            while (iter.hasNext()) {
                int iterr = iter.next();
                if ((itt != iterr) && ((itt % iterr) == 0)) {
                    Pair pair = new Pair(itt, iterr);
                    if (!pairs.contains(pair)) {
                        pairs.add(pair);
                    }
                } else if ((itt != iterr) && (iterr % itt == 0)) {
                    Pair pair = new Pair(iterr, itt);
                    if (!pairs.contains(pair)) {
                        pairs.add(pair);
                    }
                }
            }
        }
        return pairs;
    }

    public static List<Integer> permute(int[] arr) {
        List<Integer> perms = new ArrayList<>();
        permute(arr, 0, perms);
        return perms;
    }

    private static void permute(int[] arr, int index, List<Integer> perms) {
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
        pairing(arr);
    }
}
