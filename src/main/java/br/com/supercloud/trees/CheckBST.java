package br.com.supercloud.trees;

public class CheckBST {
    static boolean isBST(TreeNode n, Integer min, Integer max) {
        if (n == null) {
            return true;
        }
        if ((min != null && n.value <= min) || (max != null && n.value > max)) {
            return false;
        }
        return isBST(n.left, min, n.value) && isBST(n.right, n.value, max);
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(4);
        TreeNode lvlOneA = new TreeNode(2);
        TreeNode lvlOneB = new TreeNode(6);
        parent.left = lvlOneA;
        parent.right = lvlOneB;

        TreeNode lvlTwoA = new TreeNode(1);
        TreeNode lvlTwoB = new TreeNode(3);
        lvlOneA.left = lvlTwoA;
        lvlOneA.right = lvlTwoB;
        TreeNode lvlTwoC = new TreeNode(5);
        TreeNode lvlTwoD = new TreeNode(7);
        lvlOneB.left = lvlTwoC;
        lvlOneB.right = lvlTwoD;
        System.out.println(isBST(parent, null, null));
    }
}
