package moderatedifficulty;

//16.17 (30min)
public class MaxSumSeqFinder {

    public static int getMaxSum(int[] array) {
        int maxSum = 0;
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            if (maxSum < curSum) {
                maxSum = curSum;
            } else if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {2, -8, 3, -2, 4, -10};
        System.out.println(getMaxSum(array));
    }
}
