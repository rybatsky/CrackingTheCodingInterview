package treeandgraph.task41;

public class Node {
    private Node adjacent[];
    private int adjacentCount;
    private int vertex;
    private RouteChecker.State state;

    public Node(int vertex, int adjacentLength) {
        this.vertex = vertex;
        adjacentCount = 0;
        adjacent = new Node[adjacentLength];
    }

    public void addAdjacent(Node x) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("Maximum number of adjacent reached");
        }
    }

    public Node[] getAdjacent() {
        return adjacent;
    }

    public RouteChecker.State getState() {
        return state;
    }

    public void setState(RouteChecker.State state) {
        this.state = state;
    }
}
