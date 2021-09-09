package br.com.supercloud.trees;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class BstIsertion {

    public static void insert(TreeNode root, int data) {
        if (data > root.value && root.right == null) {
            root.right = new TreeNode(data);
        }
        if (data < root.value && root.left == null) {
            root.left = new TreeNode(data);
        }

        if (root.left != null && data < root.value) {
            insert(root.left, data);
        }
        if (root.right != null && data > root.value) {
            insert(root.right, data);
        }
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(4);
        TreeNode secondA = new TreeNode(2);
        TreeNode secondB = new TreeNode(7);
        parent.left = secondA;
        parent.right = secondB;
        secondA.left = new TreeNode(1);
        secondA.right = new TreeNode(3);

        insert(parent, 6);


        TreeMap<Integer, List<String>> valuesByLvl = new TreeMap<>();
        Bst.print(parent, valuesByLvl, 0);
        Iterator<List<String>> iterator = valuesByLvl.values().iterator();
        int lvl = 1;
        while (iterator.hasNext()) {
            List<String> lvlValues = iterator.next();
            System.out.println("Level: " + lvl);
            for (String lvlValue : lvlValues) {
                System.out.print(lvlValue + ", ");
            }
            System.out.println();
            lvl++;
        }
    }
}
