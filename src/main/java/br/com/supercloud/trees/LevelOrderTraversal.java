package br.com.supercloud.trees;

import br.com.supercloud.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    // https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
    //    1
    //      \
    //       2
    //        \
    //         5
    //        /  \
    //       3    6
    //        \
    //         4
    // For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.

    public static void main(String[] args) {
        levelOrderTraversal(Utils.buildTree(Arrays.asList(1, 2, 5, 3, 4, 6)));
    }

    private static void levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal(root, result, 0);
        String s = "asd";
        result.stream().flatMap(Collection::stream).forEach(n -> {
            System.out.print(n + " ");
        });
    }

    private static void levelOrderTraversal(TreeNode root, List<List<Integer>> levels, int level) {
        if (root == null) return;
        List<Integer> values;
        if (level == levels.size()) {
            values = new ArrayList<>();
            levels.add(values);
        } else {
            values = levels.get(level);
        }
        values.add(root.value);
        levelOrderTraversal(root.left, levels, level + 1);
        levelOrderTraversal(root.right, levels, level + 1);
    }

}
