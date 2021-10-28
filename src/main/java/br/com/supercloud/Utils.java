package br.com.supercloud;

import br.com.supercloud.trees.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static int getCharNumberUppercase(char c) {
        int a = Character.getNumericValue('A');
        int z = Character.getNumericValue('Z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
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

    public static TreeNode buildTree(List<Integer> values) {
        TreeNode root = null;
        for (Integer n : values) {
            root = insert(root, n);
        }
        return root;
    }

}
