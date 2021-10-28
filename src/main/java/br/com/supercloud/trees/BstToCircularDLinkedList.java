package br.com.supercloud.trees;

/**
 * Given a binary tree made of these nodes,
 * convert it, in-place (i.e. don't allocate new Nodes),
 * into a circular double linked list in the same order as in-order traversal of the tree.
 *
 * Input:
 * -> A
 *  /
 * B
 *  \
 *   C
 * Output:
 * -> B <-> C <->A
 *    ^          ^
 *    |----------| (circular)
 *
 *      ---4---
 *     |      |
 *    2       6
 *  |  |    |  |
 * 1   3   5   7
 *
 * (from 7) ->1<->2<->3<->4<->5<->6<->7-> (to 1)
 *
 */
public class BstToCircularDLinkedList {

    TreeNode head, prev;
    int size;
    void convertToDLinkedList(TreeNode node) {
        bstToDLinkedList(node);
        prev.right = head;
        head.left = prev;
    }


    /*private void bstToDLinkedList(TreeNode node) {
        if (node == null) return;
        size++; // not part of the algo, just used for printing
        bstToDLinkedList(node.left);
        if (head == null) {
            head = node;
            prev = node;
        } else {
            node.left = prev;
            prev.right = node;
            prev = node;
        }

        bstToDLinkedList(node.right);
    }*/

    private void bstToDLinkedList(TreeNode node) {
        if (node == null) return;
        size++;
        bstToDLinkedList(node.left);
        if (head == null) {
            head = node;
            prev = node;
        } else {
            node.left = prev;
            prev.right = node;
            prev = node;
        }
        bstToDLinkedList(node.right);
    }

    void print() {
        System.out.println(size);
        TreeNode node = head;
        for (int i = 0; i <= size; i++) {
            System.out.println(node);
            node = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode parent = new TreeNode(4);
        TreeNode secondA = new TreeNode(2);
        TreeNode secondB = new TreeNode(6);
        parent.left = secondA;
        parent.right = secondB;
        secondA.left = new TreeNode(1);
        secondA.right = new TreeNode(3);
        secondB.left = new TreeNode(5);
        secondB.right = new TreeNode(7);
        BstToCircularDLinkedList bstToCircularDLinkedList = new BstToCircularDLinkedList();
        bstToCircularDLinkedList.convertToDLinkedList(parent);
        bstToCircularDLinkedList.print();
    }
}
