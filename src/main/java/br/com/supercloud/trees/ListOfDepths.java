package br.com.supercloud.trees;


import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {

    static ArrayList<LinkedList<TreeNode>> createLinkedListDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        createLinkedListDFS(root, result, 0);
        return result;
    }

    static void createLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;
        LinkedList<TreeNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLinkedListDFS(root.left, lists, level + 1);
        createLinkedListDFS(root.right, lists, level + 1);
    }

    /*
     * Using Breath-First approach / No recursion
     */
    static ArrayList<LinkedList<TreeNode>> createLinkedListBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return result;
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
        lvlTwoA.right = lvlThreeB;
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

        System.out.println("RESULT DFS");
        ArrayList<LinkedList<TreeNode>> linkedListDFS = createLinkedListDFS(parent);
        printLists(linkedListDFS);

        System.out.println("\nRESULT BFS");
        ArrayList<LinkedList<TreeNode>> linkedListBFS = createLinkedListBFS(parent);
        printLists(linkedListBFS);
    }

    static void printLists(ArrayList<LinkedList<TreeNode>> lists) {
        lists.forEach((l) -> {
            l.forEach(System.out::println);
            System.out.println();
        });
    }
}
