package recursion;

public class Point {
    public int row;
    public int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Point) && (((Point) o).row == this.row) && (((Point) o).column == this.column);
    }
}
