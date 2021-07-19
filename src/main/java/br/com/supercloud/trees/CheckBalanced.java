package br.com.supercloud.trees;

public class CheckBalanced {
    static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    static boolean isBalanced(TreeNode root) {
      if (root == null) {
          return true;
      }
      int heightDiff = getHeight(root.left) - getHeight(root.right);
      if (Math.abs(heightDiff) > 1) {
          return false;
      } else {
          return isBalanced(root.left) && isBalanced(root.right);
      }
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(1);
        TreeNode lvlOneA = new TreeNode(2);
        TreeNode lvlOneB = new TreeNode(3);
        parent.left = lvlOneA;
        parent.right = lvlOneB;

        TreeNode lvlTwoA = new TreeNode(4);
        TreeNode lvlTwoB = new TreeNode(5);
        lvlOneA.left = lvlTwoA;
        lvlOneA.right = lvlTwoB;
        TreeNode lvlTwoC = new TreeNode(6);
        TreeNode lvlTwoD = new TreeNode(7);
        lvlOneB.left = lvlTwoC;
        lvlOneB.right = lvlTwoD;

        TreeNode lvlThreeA = new TreeNode(8);
        TreeNode lvlThreeB = new TreeNode(9);
        lvlTwoA.left = lvlThreeA;
        lvlTwoA.right = lvlThreeA;
        TreeNode lvlThreeC = new TreeNode(10);
        TreeNode lvlThreeD = new TreeNode(11);
        lvlTwoB.left = lvlThreeC;
        lvlTwoB.right = lvlThreeD;
        TreeNode lvlThreeE = new TreeNode(12);
        TreeNode lvlThreeF = new TreeNode(13);
        lvlTwoC.left = lvlThreeE;
        lvlTwoC.right = lvlThreeF;
        TreeNode lvlThreeG = new TreeNode(14);
        TreeNode lvlThreeH = new TreeNode(15);
        lvlTwoD.left = lvlThreeG;
        lvlTwoD.right = lvlThreeH;

        System.out.println(isBalanced(parent));

        parent.right.right=null;
        System.out.println(isBalanced(parent));
    }
}
