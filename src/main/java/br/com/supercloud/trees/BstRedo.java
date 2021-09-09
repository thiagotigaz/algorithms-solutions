package br.com.supercloud.trees;

public class BstRedo {

    public static boolean isBst(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.value <= min) || (max != null && root.value > max)) {
            return false;
        }
        return isBst(root.left, min, root.value) && isBst(root.right, root.value, max);
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
        System.out.println(isBst(parent, null, null));
    }

}
