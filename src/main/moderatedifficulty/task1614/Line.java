package moderatedifficulty.task1614;

public class Line {
    private double slope;
    private double intercept;
    public final static double EPS = .01;

    public Line(Point p, Point q) {
        if (Math.abs(p.getX() - q.getX()) > EPS) {
            slope = (p.getY() - q.getY()) / (p.getX() - q.getX());
            intercept = p.getY() - slope * p.getX();
        }
    }

    public static double nearestEps(double d) {
        int r = (int) (d / EPS);
        return ((double) r) * EPS;
    }

    public double getSlope() {
        return slope;
    }

    @Override
    public String toString() {
        return "y = " + slope + "x + " + intercept;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return Math.abs(line.slope - slope) < EPS && Math.abs(line.intercept - intercept) < EPS;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(slope);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(intercept);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
