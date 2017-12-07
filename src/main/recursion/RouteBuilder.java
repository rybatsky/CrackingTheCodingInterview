package recursion;

import java.util.ArrayList;
import java.util.Random;

//8.2 (60min)
public class RouteBuilder {

    public static ArrayList<Point> getPath(boolean[][] field) {
        if (field == null || field.length == 0) {
            return null;
        }

        ArrayList<Point> path = new ArrayList<>();
        if (getPath(field, field.length - 1, field[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    public static boolean getPath(boolean[][] field, int row, int col, ArrayList<Point> path) {
        if (col < 0 || row < 0 || !field[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);
        if (isAtOrigin || getPath(field, row, col - 1, path) || getPath(field, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int size = 5;
        boolean[][] matrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Random rand = new Random();
                int x = rand.nextInt(100);
                System.out.println(x);
                matrix[i][j] = x % 2 == 0;
            }
        }

        for (boolean[] aMatrix : matrix) {
            for (int j = 0; j < aMatrix.length; j++) {
                if (aMatrix[j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }

        ArrayList<Point> path = getPath(matrix);
        if (path != null) {
            System.out.println(path.toString());
        } else {
            System.out.println("No path found.");
        }
    }
}
