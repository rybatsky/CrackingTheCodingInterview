package moderatedifficulty;

import java.util.ArrayList;

//16.19 (40min)
public class LakesFinder {
    
    public static ArrayList<Integer> computeLakeSizes(int[][] land) {
        ArrayList<Integer> lakeSizes = new ArrayList<>();
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[row].length; col++) {
                if (land[row][col] == 0) {
                    int size = computeSize(land, row, col);
                    lakeSizes.add(size);
                }
            }
        }
        return lakeSizes;
    }

    public static int computeSize(int[][] land, int row, int col) {
        if (row < 0 || col < 0 || row >= land.length || col >= land[row].length || land[row][col] != 0) {
            return 0;
        }
        int size = 1;
        land[row][col] = -1;
        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                size += computeSize(land, row + dRow, col + dCol);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        ArrayList<Integer> sizes = computeLakeSizes(land);
        for (int s : sizes) {
            System.out.println(s);
        }
    }
}
