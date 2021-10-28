package br.com.supercloud.trees;

public class HuffmanDecoding {

    // https://www.hackerrank.com/challenges/tree-huffman-decoding/problem
    //
    //    Sample Input
    //    s="1001011"
    //
    //    Sample Output
    //    ABACA
    static void decode(String s, TreeNode root) {
        TreeNode current = null;
        while (!s.equals("")) {
            if (current == null) {
                current = root;
            } else {
                current = s.charAt(0) == '1' ? current.right : current.left;
                s = s.substring(1);
            }

            if (current.left == null && current.right == null) {
                System.out.print(current.letter);
                current = root;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3, 'A');

        parent.left = left;
        parent.right = right;

        left.left = new TreeNode(1, 'B');
        left.right = new TreeNode(1, 'C');

        decode("1001011", parent);
    }
}
