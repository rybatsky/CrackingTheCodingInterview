package recursion;

import java.util.ArrayList;

//8.12 (40min)
public class QueenPlacer {

    public static int GRID_SIZE = 8;

    public static boolean vacant(Integer[] columns, int row, int column) {
        for (int rowRunner = 0; rowRunner < row; rowRunner++) {
            int columnRunner = columns[rowRunner];
            if (column == columnRunner) {
                return false;
            }

            int columnDistance = Math.abs(columnRunner - column);
            int rowDistance = row - rowRunner;
            if (columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    public static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int columnRunner = 0; columnRunner < GRID_SIZE; columnRunner++) {
                if (vacant(columns, row, columnRunner)) {
                    columns[row] = columnRunner;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    public static void printBoards(ArrayList<Integer[]> boards) {
        for (Integer[] board : boards) {
            String line = ("-----------------");
            System.out.println(line);
            for (int i = 0; i < GRID_SIZE; i++) {
                System.out.print("|");
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (board[i] == j) {
                        System.out.print("Q|");
                    } else {
                        System.out.print(" |");
                    }
                }
                System.out.print("\n");
                System.out.println(line);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<>();
        Integer[] columns = new Integer[GRID_SIZE];
        placeQueens(0, columns, results);
        System.out.println(results.size());
        printBoards(results);
    }
}
