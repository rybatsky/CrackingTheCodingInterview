package linkedlist;

//2.6 (70min)
public class PalindromeChecker {

    public static boolean isPalindrome(Node head) {
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public static Node reverseAndClone(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public static boolean isEqual(Node one, Node two) {
        while (one != null && two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(2);
        node.appendToTail(1);
        System.out.println(isPalindrome(node));
        Node node2 = new Node(1);
        node2.appendToTail(2);
        node2.appendToTail(3);
        System.out.println(isPalindrome(node2));
    }
}