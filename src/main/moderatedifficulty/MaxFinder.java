package moderatedifficulty;

//16.7 (50min)
public class MaxFinder {
    public static int flip(int bit) {
        return 1 ^ bit;
    }

    public static int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    public static int getMax(int a, int b) {
        int c = a - b;

        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int signA = sa ^ sb;
        int signC = flip(sa ^ sb);

        int k = signA * sa + signC * sc;
        int q = flip(k);

        return a * k + b * q;
    }

    public static void main(String[] args) {

        int a = 123;
        int b = -123;
        System.out.println("max(" + a + ", " + b + ") = " + getMax(a, b));

        int a1 = -2147483647;
        int b1 = 2147483647;
        System.out.println("max(" + a1 + ", " + b1 + ") = " + getMax(a1, b1));

        int a2 = 0;
        int b2 = -1;
        System.out.println("max(" + a2 + ", " + b2 + ") = " + getMax(a2, b2));
    }
}
