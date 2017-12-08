package test;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private int dividend;
    private int divisor;
    private List<Pair> pairs = new ArrayList<>();

    public Pair(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public String toString() {
        return "Pair: " +
                "dividend=" + dividend +
                ", divisor=" + divisor;
    }
}
