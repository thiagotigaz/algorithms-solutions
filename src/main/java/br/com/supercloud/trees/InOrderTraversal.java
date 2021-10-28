package br.com.supercloud.trees;

import br.com.supercloud.Utils;

import java.util.Arrays;

public class InOrderTraversal {
    // https://www.hackerrank.com/challenges/tree-inorder-traversal/problem
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
        printTree(Utils.buildTree(Arrays.asList(1,2,5,3,4,6))); // 1 2 3 4 5 6
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }

}
