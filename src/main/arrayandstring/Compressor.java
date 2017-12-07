package arrayandstring;

//1.6 (40min)
public class Compressor {

    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder(str.length());
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }

        if (compressed.length() < str.length()) {
            return compressed.toString();
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println(compress(""));
        System.out.println(compress("  "));
        System.out.println(compress("ababababab"));
        System.out.println(compress("aaaaaaaaabababab"));
        System.out.println(compress("aaaaaaaaabbbbbbbbbb"));
    }
}
