package treeandgraph.task410;

import treeandgraph.task43.TreeNode;

import static treeandgraph.TreeBuilder.fromArray;

//4.10 (60min)
public class SubtreeChecker {

    public static boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    public static void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }
        sb.append(node.getData());
        getOrderString(node.getLeft(), sb);
        getOrderString(node.getRight(), sb);
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 1, 3, 1, 1, 5};
        int[] array2 = {2, 3, 1};

        TreeNode t1 = fromArray(array1);
        TreeNode t2 = fromArray(array2);

        if (containsTree(t1, t2)) {
            System.out.println("t2 is a subtree of t1");
        } else {
            System.out.println("t2 is not a subtree of t1");
        }

        int[] array3 = {1, 2, 3};
        TreeNode t3 = fromArray(array1);
        TreeNode t4 = fromArray(array3);

        if (containsTree(t3, t4)) {
            System.out.println("t4 is a subtree of t3");
        } else {
            System.out.println("t4 is not a subtree of t3");
        }
    }
}
