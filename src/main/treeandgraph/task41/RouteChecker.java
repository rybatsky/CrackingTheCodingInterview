package treeandgraph.task41;

import java.util.LinkedList;

//4.1 (60min)
public class RouteChecker {
    public enum State { UNVISITED, VISITED, CURRENT };

    public static boolean route(DirectedGraph graph, Node start, Node end) {
        if (start == end) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();
        for (Node node : graph.getNodes()) {
            node.state = State.UNVISITED;
        }
        start.state = State.CURRENT;
        queue.add(start);

        Node node;
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            if (node != null) {
                for (Node adj : node.getAdjacent()) {
                    if (adj.state == State.UNVISITED) {
                        if (adj == end) {
                            return true;
                        }
                    } else {
                        adj.state = State.CURRENT;
                        queue.add(adj);
                    }
                }
            }
            node.state = State.VISITED;
        }
        return false;
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(6);
        Node[] nodes = new Node[6];

        nodes[0] = new Node(1, 2);
        nodes[1] = new Node(2, 1);
        nodes[2] = new Node(3, 2);
        nodes[3] = new Node(4, 1);
        nodes[4] = new Node(5, 0);
        nodes[5] = new Node(6, 0);

        nodes[0].addAdjacent(nodes[1]);
        nodes[0].addAdjacent(nodes[2]);
        nodes[1].addAdjacent(nodes[3]);
        nodes[2].addAdjacent(nodes[4]);
        nodes[2].addAdjacent(nodes[5]);

        for (int i = 0; i < nodes.length; i++) {
            g.addNode(nodes[i]);
        }

        System.out.println(route(g, nodes[2], nodes[3]));
        System.out.println(route(g, nodes[2], nodes[4]));
    }
}
