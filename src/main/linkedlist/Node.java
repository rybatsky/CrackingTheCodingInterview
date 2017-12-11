package linkedlist;

public class Node {
    private Node next;
    private int data;

    public Node() {
    }

    public Node(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        n.setNext(end);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " " + next;
    }
}
