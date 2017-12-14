package hard;

//17.21 (60min)
public class WaterCounter {

    public static int findIndexOfMax(int[] histogram, int start, int end) {
        int indexOfMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (histogram[i] > histogram[indexOfMax]) {
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }

    public static int borderedVolume(int[] histogram, int start, int end) {
        if (start >= end) return 0;

        int min = Math.min(histogram[start], histogram[end]);
        int sum = 0;
        for (int i = start + 1; i < end; i++) {
            sum += min - histogram[i];
        }
        return sum;
    }

    public static int subHistVolume(int[] histogram, int start, int end, boolean isLeft) {
        if (start >= end) return 0;
        int sum = 0;
        if (isLeft) {
            int max = findIndexOfMax(histogram, start, end - 1);
            sum += borderedVolume(histogram, max, end);
            sum += subHistVolume(histogram, start, max, isLeft);
        } else {
            int max = findIndexOfMax(histogram, start + 1, end);
            sum += borderedVolume(histogram, start, max);
            sum += subHistVolume(histogram, max, end, isLeft);
        }

        return sum;
    }

    public static int computeHistogramVolume(int[] histogram) {
        int start = 0;
        int end = histogram.length - 1;

        int max = findIndexOfMax(histogram, start, end);

        int leftVolume = subHistVolume(histogram, start, max, true);
        int rightVolume = subHistVolume(histogram, max, end, false);

        return leftVolume + rightVolume;
    }

    public static void main(String[] args) {
        int[] histogram = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 5, 0, 1, 0, 0, 0};
        System.out.println(computeHistogramVolume(histogram));
    }
}
