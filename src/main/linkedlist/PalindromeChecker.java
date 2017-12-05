package linkedlist;

//2.6
public class PalindromeChecker {

    public boolean isPalindrome(Node head) {
        Node reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    public Node reverseAndClone(Node node) {
        Node head = null;
        while (node != null) {
            Node n = new Node(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    public boolean isEqual(Node one, Node two) {
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
        PalindromeChecker pc = new PalindromeChecker();
        Node node = new Node(1);
        node.appendToTail(2);
        node.appendToTail(1);
        System.out.println(pc.isPalindrome(node));
        Node node2 = new Node(1);
        node2.appendToTail(2);
        node2.appendToTail(3);
        System.out.println(pc.isPalindrome(node2));
    }
}
