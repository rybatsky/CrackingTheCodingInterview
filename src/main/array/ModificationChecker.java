package array;

//1.5
public class ModificationChecker {

    public boolean isOneModificationAway(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();

        if(Math.abs(length2 - length1) > 1) {
            return false;
        }

        int max;
        int min;
        String biggerStr;
        String  smallerStr;
        if (length1 > length2) {
            max = length1;
            min = length2;
            biggerStr = s1;
            smallerStr = s2;
        } else {
            max = length2;
            min = length1;
            biggerStr = s2;
            smallerStr = s1;
        }

        int i = 0;
        int j = 0;
        boolean dif = false;
        while (i < min && j < max) {
            if (smallerStr.charAt(i) != biggerStr.charAt(j)) {
                if (dif) {
                    return false;
                }
                dif = true;

                if (min == max) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }

        return true;
    }

    public static void main(String[] args) {
        ModificationChecker om = new ModificationChecker();
        System.out.println(om.isOneModificationAway("a", ""));
        System.out.println(om.isOneModificationAway("", "b"));
        System.out.println(om.isOneModificationAway("ab", ""));
        System.out.println(om.isOneModificationAway("ab", "b"));
        System.out.println(om.isOneModificationAway("ba", "b"));
        System.out.println(om.isOneModificationAway("ba", "bc"));
        System.out.println(om.isOneModificationAway("bab", "bc"));
        System.out.println(om.isOneModificationAway("ab", "ac"));
        System.out.println(om.isOneModificationAway("abc", "adc"));
        System.out.println(om.isOneModificationAway("abc", "acd"));
    }
}
