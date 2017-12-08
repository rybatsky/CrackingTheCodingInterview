package treeandgraph.task41;

public class DirectedGraph {
    public Node[] nodes;
    public int count;

    public DirectedGraph(int nodesNumber) {
        nodes = new Node[nodesNumber];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < nodes.length) {
            nodes[count] = x;
            count++;
        } else {
            System.out.print("Maximum number of nodes reached");
        }
    }

    public Node[] getNodes() {
        return nodes;
    }
}
