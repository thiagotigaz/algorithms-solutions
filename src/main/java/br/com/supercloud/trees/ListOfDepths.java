package br.com.supercloud.trees;


import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

    /**
     * Using Depth-First approach / recursion
     */
    void createLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root); // add to current level list
        createLinkedListDFS(root.left, lists, level + 1); // move on recursively to next level
        createLinkedListDFS(root.right, lists, level + 1); // move on recursively to next level
    }

    ArrayList<LinkedList<TreeNode>> createLinkedListDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLinkedListDFS(root, lists, 0);
        return lists;
    }

    /*
     * Using Breath-First approach / No recursion
     */
    ArrayList<LinkedList<TreeNode>> createLinkedListBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

}
