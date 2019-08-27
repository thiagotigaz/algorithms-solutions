package br.com.supercloud.trees;

public class MinimalTree {

    static TreeNode createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length);
    }

    static private TreeNode createMinimalBST(int[] array, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(mid);
        n.left = createMinimalBST(array, start, mid - 1);
        n.right = createMinimalBST(array, mid + 1, end);
        return n;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode minimalBST = createMinimalBST(array);
        printTree(minimalBST);
    }

    private static void printTree(TreeNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.value);
            printTree(node.right);
        }
    }
}
