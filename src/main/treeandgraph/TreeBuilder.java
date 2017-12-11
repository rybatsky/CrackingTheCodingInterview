package treeandgraph;

import treeandgraph.task43.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {

    public static TreeNode fromArray(int[] array) {
        if (array.length > 0) {
            TreeNode root = new TreeNode(array[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean done = false;
            int i = 1;
            while (!done) {
                TreeNode r = queue.element();
                if (r.getLeft() == null) {
                    r.setLeft(new TreeNode(array[i]));
                    i++;
                    queue.add(r.getLeft());
                } else if (r.getRight() == null) {
                    r.setRight(new TreeNode(array[i]));
                    i++;
                    queue.add(r.getRight());
                } else {
                    queue.remove();
                }
                if (i == array.length)
                    done = true;
            }
            return root;
        } else {
            return null;
        }
    }
}
