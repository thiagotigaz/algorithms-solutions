package br.com.supercloud.trees;

public class TreeNode {

    public int value;
    public char letter;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, char letter) {
        this.value = value;
        this.letter = letter;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
