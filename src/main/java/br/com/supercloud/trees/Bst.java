package br.com.supercloud.trees;

import java.util.*;


public class Bst {

    //             1
    //    2                 5
    //3       4         6       7
    public static void print(
            TreeNode parent, Map<Integer, List<String>> valuesByLvl, int lvl
    ) {
        if (parent == null) {
            return;
        }
        if (!valuesByLvl.containsKey(lvl)) {
            List<String> lvlValues = new ArrayList<>();
            lvlValues.add(String.valueOf(parent.value));
            valuesByLvl.put(lvl, lvlValues);
        } else {
            valuesByLvl.get(lvl).add(String.valueOf(parent.value));
        }
        print(parent.left, valuesByLvl, lvl + 1);
        print(parent.right, valuesByLvl, lvl + 1);
    }


    public static void main(String[] args) {
        TreeNode parent = new TreeNode(1);
        TreeNode secondA = new TreeNode(2);
        TreeNode secondB = new TreeNode(3);
        parent.left = secondA;
        parent.right = secondB;
        TreeMap<Integer, List<String>> valuesByLvl = new TreeMap<>();
        print(parent, valuesByLvl, 0);
        Iterator<List<String>> iterator = valuesByLvl.values().iterator();
        int lvl = 1;
        while (iterator.hasNext()) {
            List<String> lvlValues = iterator.next();
            System.out.println("Level: " + lvl);
            for (String lvlValue : lvlValues) {
                System.out.print(lvlValue + ", ");
            }
            System.out.println();
        }
    }
}
