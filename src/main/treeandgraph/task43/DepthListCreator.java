package treeandgraph.task43;

import java.util.*;

import static treeandgraph.TreeBuilder.fromArray;

//4.3 (60min)
public class DepthListCreator {

    public static void createLevelLinkedList(TreeNode root, List<List<TreeNode>> lists, int level) {
        if (root == null) return;
        List<TreeNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.getLeft(), lists, level + 1);
        createLevelLinkedList(root.getRight(), lists, level + 1);
    }

    public static List<List<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<List<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = fromArray(array);
        List<List<TreeNode>> list = createLevelLinkedList(root);
        int depth = 0;
        for (List<TreeNode> entry : list) {
            Iterator<TreeNode> it = entry.listIterator();
            System.out.print("Linked list at depth " + depth + ":");
            while (it.hasNext()) {
                System.out.print(" " + (it.next()).getData());
            }
            System.out.println();
            depth++;
        }
    }
}
