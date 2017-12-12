package moderatedifficulty;

import java.util.LinkedList;
import java.util.Random;

//16.8 (60min)
public class NumberWriter {
    private static final String[] LESS_THAN_TWENTY = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] MORE_THAN_THOUSAND = {"", "Thousand", "Million", "Billion"};
    private static final String HUNDRED = "Hundred";
    private static final String NEGATIVE = "Negative";

    public static String convert(int num) {
        if (num == 0) {
            return LESS_THAN_TWENTY[0];
        } else if (num < 0) {
            return NEGATIVE + " " + convert(-1 * num);
        }

        LinkedList<String> parts = new LinkedList<>();
        int n = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                String remainder = remain(num % 1000) + " " + MORE_THAN_THOUSAND[n];
                parts.addFirst(remainder);
            }
            num /= 1000;
            n++;
        }

        return parts.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }

    public static String remain(int number) {
        LinkedList<String> parts = new LinkedList<>();

        if (number >= 100) {
            parts.addLast(LESS_THAN_TWENTY[number / 100]);
            parts.addLast(HUNDRED);
            number %= 100;
        }

        if (number >= 10 && number <= 19) {
            parts.addLast(LESS_THAN_TWENTY[number]);
        } else if (number >= 20) {
            parts.addLast(TENS[number / 10]);
            number %= 10;
        }

        if (number >= 1 && number <= 9) {
            parts.addLast(LESS_THAN_TWENTY[number]);
        }

        return parts.toString();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int k = 10; k < 1000000000; k *= 10){
                int posValue = rand.nextInt(k) + k / 10;
                int negValue = -1 * rand.nextInt(k) + k / 10;
                String p = convert(posValue);
                String n = convert(negValue);
                System.out.println(posValue + ": " + p);
                System.out.println(negValue + ": " + n);
        }
    }
}
