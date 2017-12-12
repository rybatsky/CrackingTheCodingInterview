package moderatedifficulty.task1624;

import java.util.ArrayList;
import java.util.List;

//16.24 (30min)
public class PairFinder {

    public static List<Pair> pairsFinder(int[] array, int sum) {
        List<Pair> result = new ArrayList<>();
        for (int i = 0 ; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    Pair pair = new Pair(array[i], array[j]);
                    if (!result.contains(pair)) {
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {-11, -10, -9, 0, 2, 9, 2, 11, 20, 21, 22};
        List<Pair> pairs = pairsFinder(array, 11);
        for (Pair p : pairs) {
            System.out.println(p.toString());
        }
    }
}
