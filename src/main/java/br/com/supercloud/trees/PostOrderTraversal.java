package br.com.supercloud.trees;

import br.com.supercloud.Utils;

import java.util.Arrays;

public class PostOrderTraversal {
    // https://www.hackerrank.com/challenges/tree-postorder-traversal/problem
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
        printTree(Utils.buildTree(Arrays.asList(1,2,5,3,4,6))); // 4 3 6 5 2 1
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            printTree(root.right);
            System.out.print(root.value + " ");
        }
    }

}
