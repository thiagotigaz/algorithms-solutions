package br.com.supercloud.trees;

import br.com.supercloud.Utils;

import java.util.Arrays;

public class PreOrderTraversal {
    // https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
    //     1
    //      \
    //       2
    //        \
    //         5
    //        /  \
    //       3    6
    //        \
    //         4
    public static void main(String[] args) {
        printTree(Utils.buildTree(Arrays.asList(1,2,5,3,4,6))); // 1 2 5 3 4 6
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

}
