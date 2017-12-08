package treeandgraph.task41;

public class Node {
    public Node adjacent[];
    public int adjacentCount;
    public int vertex;
    public RouteChecker.State state;

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
}
