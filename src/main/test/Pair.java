package test;

public class Pair {
    private int dividend;
    private int divisor;

    public Pair(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (dividend != pair.dividend) return false;
        return divisor == pair.divisor;
    }

    @Override
    public int hashCode() {
        int result = dividend;
        result = 31 * result + divisor;
        return result;
    }

    @Override
    public String toString() {
        return "Pair: " +
                "dividend=" + dividend +
                ", divisor=" + divisor;
    }
}
