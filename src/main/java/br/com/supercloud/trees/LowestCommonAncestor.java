package br.com.supercloud.trees;

import java.util.Arrays;
import java.util.List;

public class LowestCommonAncestor {
    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    public static TreeNode lca(TreeNode root, int v1, int v2) {
        if (root.value < v1 && root.value < v2) return lca(root.right, v1, v2);
        if (root.value > v1 && root.value > v2) return lca(root.left, v1, v2);
        return root;
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if (data <= root.value) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        // 4 2 3 1 7 6
        //System.out.println(lca(buildTree(Arrays.asList(4,2,3,1,7,6)), 1, 7).value); // 4
        // 2 1 3 4 5 6
        System.out.println(lca(buildTree(Arrays.asList(1, 2)), 1, 2).value); // 1
        System.out.println(lca(buildTree(Arrays.asList(4, 2, 3, 1, 7, 6)), 1, 7).value); // 4
        System.out.println(lca(buildTree(Arrays.asList(4, 2, 3, 1, 7, 6)), 6, 7).value); // 7
        System.out.println(lca(buildTree(Arrays.asList(4, 2, 3, 1, 7, 6)), 1, 3).value); // 2
        System.out.println(lca(buildTree(Arrays.asList(4, 2, 3, 1, 6, 7)), 6, 7).value); // 6
        System.out.println(lca(buildTree(Arrays.asList(2, 3, 5, 4, 6, 1)), 4, 6).value); // 3
        System.out.println(lca(buildTree(Arrays.asList(5, 3, 8, 2, 4, 6, 7)), 7, 3).value); // 5
    }

    private static TreeNode buildTree(List<Integer> values) {
        TreeNode root = null;
        for (Integer n : values) {
            root = insert(root, n);
        }
        return root;
    }
}
