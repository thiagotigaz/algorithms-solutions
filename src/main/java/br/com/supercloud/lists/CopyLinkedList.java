package br.com.supercloud.lists;

public class CopyLinkedList {

    public static void main(String[] args) {
        Node five = new Node(5, null);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node one = new Node(1, two);

        printLinkedList(one);
        Node copy = copyLinkedList(one);
        printLinkedList(copy);
    }

    static class Node {

        int value;

        Node next;

        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    static Node copyLinkedList(Node node) {
        if (node == null) {
            return null;
        }
        Node head = new Node(node.value, node.next);
        Node runner = head;
        while (runner.next != null) {
            runner.next = new Node(runner.next.value, runner.next.next);
            runner = runner.next;
        }
        return head;
    }

    static void printLinkedList(Node node) {
        while (node != null) {
            System.out.println(node.value + " - " + node.hashCode());
            node = node.next;
        }
    }
}
