package moderatedifficulty.task1614;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

//16.14 (180min)
public class MaxDotsLiner {

    public static Line findBestLine(Point[] points) {
        HashMap<Double, List<Line>> linesBySlope = getListOfLines(points);
        return getBestLine(linesBySlope);
    }

    public static HashMap<Double, List<Line>> getListOfLines(Point[] points) {
        HashMap<Double, List<Line>> linesBySlope = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                double key = Line.nearestEps(line.getSlope());
                if (!linesBySlope.containsKey(key)) {
                    linesBySlope.put(key, new ArrayList<>());
                }
                linesBySlope.get(key).add(line);
            }
        }
        return linesBySlope;
    }

    public static Line getBestLine(HashMap<Double, List<Line>> linesBySlope) {
        Line bestLine = null;
        int bestCount = 0;

        Set<Double> slopes = linesBySlope.keySet();

        for (double slope : slopes) {
            List<Line> lines = linesBySlope.get(slope);
            for (Line line : lines) {
                int count = countEquivalentLines(linesBySlope, line);

                if (count > bestCount) {
                    bestLine = line;
                    bestCount = count;
                }
            }
        }
        return bestLine;
    }

    public static int countEquivalentLines(HashMap<Double, List<Line>> linesBySlope, Line line) {
        double key = Line.nearestEps(line.getSlope());
        int count = countEquivalentLines(linesBySlope.get(key), line);
        count += countEquivalentLines(linesBySlope.get(key - Line.EPS), line);
        count += countEquivalentLines(linesBySlope.get(key + Line.EPS), line);
        return count;
    }

    public static int countEquivalentLines(List<Line> lines, Line line) {
        if (lines == null) {
            return 0;
        }

        int count = 0;
        for (Line parallelLine : lines) {
            if (parallelLine.equals(line)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Point[] points = new Point[100];
        for (int i = 0; i < 100; i++) {
            double x = 10 * random.nextDouble();
            double y = 10 * random.nextDouble();
            Point p = new Point(x, y);
            points[i] = p;
        }
        System.out.println(findBestLine(points).toString());
    }
}
