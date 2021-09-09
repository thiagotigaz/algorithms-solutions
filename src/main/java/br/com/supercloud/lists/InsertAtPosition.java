package br.com.supercloud.lists;

public class InsertAtPosition {
    // https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode node = llist;
        int idx = 1;
        while (idx < position) {
            node = node.next;
            idx++;
        }
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        newNode.next = node.next;
        node.next = newNode;

        return llist;
    }
}
