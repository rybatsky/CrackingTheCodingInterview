package sortandsearch;

//10.3 (30min)
public class RotatedSortFinder {

    public static int search(int a[], int x) {
        return search(a, 0, a.length - 1, x);
    }

    public static int search(int a[], int start, int end, int x) {
        int mid = (start + end) / 2;
        if (x == a[mid]) {
            return mid;
        }
        if (end < start) {
            return -1;
        }

        if (a[start] < a[mid]) {
            if (x >= a[start] && x < a[mid]) {
                return search(a, start, mid - 1, x);
            } else {
                return search(a, mid + 1, end, x);
            }
        } else if (a[mid] < a[start]) {
            if (x > a[mid] && x <= a[end]) {
                return search(a, mid + 1, end, x);
            } else {
                return search(a, start, mid - 1, x);
            }
        } else if (a[start] == a[mid]) {
            if (a[mid] != a[end]) {
                return search(a, mid + 1, end, x);
            } else {
                int result = search(a, start, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, end, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {14, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(search(a, 5));
        System.out.println(search(a, 3));
        System.out.println(search(a, 4));
        System.out.println(search(a, 1));
        System.out.println(search(a, 8));
    }
}
