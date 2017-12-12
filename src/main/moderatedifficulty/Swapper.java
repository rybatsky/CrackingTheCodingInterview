package moderatedifficulty;

//16.1 (30min)
public class Swapper {

    public static void swap(int a, int b) {
        a = a - b;
        b = a + b;
        a = b - a;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    public static void main(String[] args) {
        int a = 1234;
        int b = 9876;

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        swap(a, b);
    }
}
