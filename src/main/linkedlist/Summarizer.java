package linkedlist;

//2.5 (70min)
public class Summarizer {

    public static Node reverseSum(Node summand1, Node summand2, int carry) {
        if (summand1 == null && summand2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (summand1 != null) {
            sum += summand1.data;
        }
        if (summand2 != null) {
            sum += summand2.data;
        }

        Node result = new Node();
        result.data = sum % 10;

        Node node1 = null;
        Node node2 = null;
        if (summand1 != null || summand2 != null) {
            if (summand1 != null) {
                node1 = summand1.next;
            }
            if (summand2 != null) {
                node2 = summand2.next;
            }
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            Node node = reverseSum(node1, node2, carry);
            result.setNext(node);
        }

        return result;
    }

    public static Node reverseSum(Node summand1, Node summand2) {
        return reverseSum(summand1, summand2, 0);
    }

    public static void main(String[] args) {
        Node summand1 = new Node(7);
        summand1.appendToTail(1);
        summand1.appendToTail(6);
        Node summand2 = new Node(5);
        summand2.appendToTail(9);
        summand2.appendToTail(2);
        Node node = reverseSum(summand1, summand2);
        System.out.println(node);
    }
}
