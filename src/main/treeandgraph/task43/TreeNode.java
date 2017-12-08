package treeandgraph.task43;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }
}
