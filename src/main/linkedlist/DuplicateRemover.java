package linkedlist;

//2.1 (50min)
public class DuplicateRemover {

    public static void remove(Node node) {
        while (node != null) {
            Node runner = node;
            while (runner.getNext() != null) {
                if (runner.getNext().getData() == node.getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.appendToTail(2);
        node.appendToTail(1);
        node.appendToTail(1);
        node.appendToTail(10);
        node.appendToTail(111);
        remove(node);
        System.out.println(node);
    }
}
