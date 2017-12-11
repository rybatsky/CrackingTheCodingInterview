package linkedlist;

//2.4 (60min)
public class Divider {

    public static Node divide(Node node, int pivot) {
        Node beforeStart = null;
        Node afterStart = null;
        Node beforeEnd = null;
        Node afterEnd = null;

        while (node != null) {
            Node next = node.getNext();
            node.setNext(null);

            if (node.getData() < pivot) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.setNext(node);
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.setNext(node);
                    afterEnd = node;
                }
            }

            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.setNext(afterStart);
        return beforeStart;
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.appendToTail(5);
        node.appendToTail(8);
        node.appendToTail(5);
        node.appendToTail(10);
        node.appendToTail(2);
        node.appendToTail(1);
        System.out.println(divide(node, 5));
    }
}
