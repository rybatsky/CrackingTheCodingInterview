package array;

//1.6
public class Compressor {

    public String compress(String str) {
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
        Compressor cs = new Compressor();
        System.out.println(cs.compress(""));
        System.out.println(cs.compress("  "));
        System.out.println(cs.compress("ababababab"));
        System.out.println(cs.compress("aaaaaaaaabababab"));
        System.out.println(cs.compress("aaaaaaaaabbbbbbbbbb"));
    }
}
