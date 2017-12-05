package linkedlist;

//2.1
public class DuplicateRemover {

    public void remove(Node node) {
        while (node != null) {
            Node runner = node;
            while (runner.next != null) {
                if (runner.next.data == node.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DuplicateRemover dr = new DuplicateRemover();
        Node node = new Node();
        node.appendToTail(1);
        node.appendToTail(2);
        node.appendToTail(1);
        node.appendToTail(1);
        node.appendToTail(10);
        node.appendToTail(111);
        dr.remove(node);
        System.out.println(node);
    }
}
