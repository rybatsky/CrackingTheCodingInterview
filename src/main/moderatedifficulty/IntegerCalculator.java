package moderatedifficulty;

import java.util.Random;

//16.9 (60min)
public class IntegerCalculator {

    public static int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += newSign;
            a += newSign;
        }
        return neg;
    }

    public static int minus(int a, int b) {
        return a + negate(b);
    }

    public static int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }

    public static int multiply(int a, int b) {
        if (a < b) {
            return multiply(b, a);
        }
        int sum = 0;
        for (int i = abs(b); i > 0; i = minus(i, 1)) {
            sum += a;
        }
        if (b < 0) {
            sum = negate(sum);
        }
        return sum;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("ERROR: Can't divide by zero.");
        }
        int absA = abs(a);
        int absB = abs(b);

        int product = 0;
        int x = 0;
        while (product + absB <= absA) {
            product += absB;
            x++;
        }

        if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
            return x;
        } else {
            return negate(x);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int min = -100;
        int max = 100;

        int a = rand.nextInt(max - min + 1) + min;
        int b = rand.nextInt(max - min + 1) + min;
        int ans = minus(a, b);
        if (ans != a - b) {
            System.out.println("ERROR: " + ans + " != " + a + " - " + b);
        } else {
            System.out.println(a + " - " + b + " = " + ans);
        }

        int a1 = rand.nextInt(max - min + 1) + min;
        int b1 = rand.nextInt(max - min + 1) + min;
        int ans1 = multiply(a1, b1);
        if (ans1 != a1 * b1) {
            System.out.println("ERROR: " + ans1 + " != " + a1 + " * " + b1);
        }
        System.out.println(a1 + " * " + b1 + " = " + ans1);

        int a2 = rand.nextInt(max - min + 1) + min;
        int b2 = rand.nextInt(max - min + 1) + min;
        try {
            int ans2 = divide(a2, b2);
            if (ans2 != a2 / b2) {
                System.out.println("ERROR: " + ans2 + "!=" + a2 + "/" + b2);
            } else {
                System.out.println(a2 + " / " + b2 + " = " + ans2);
            }
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
