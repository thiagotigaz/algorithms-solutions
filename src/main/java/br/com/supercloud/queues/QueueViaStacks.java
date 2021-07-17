package br.com.supercloud.queues;

import java.util.Stack;

public class QueueViaStacks {

    // Cracking the coding interview #3.4 Queue Via Stacks
    static class Queue<T> {
        Stack<T> stackNewest = new Stack<>();
        Stack<T> stackOldest = new Stack<>();

        int size() {
            return stackNewest.size() + stackOldest.size();
        }

        void add(T value) {
            stackNewest.push(value);
        }

        private void shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            shiftStacks();
            return stackOldest.peek();
        }

        public T remove() {
            shiftStacks();
            return stackOldest.pop();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> myQueue = new Queue<>();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println("peek: " + myQueue.peek());
        System.out.println("remove: " + myQueue.remove());
        System.out.println("size: " + myQueue.size());
        System.out.println("remove: " + myQueue.remove());
        System.out.println("remove: " + myQueue.remove());
        myQueue.add(4);
        System.out.println("size: " + myQueue.size());
        System.out.println("peek: " + "peek: " + myQueue.peek());
        myQueue.add(5);
        System.out.println("size: " + myQueue.size());
        System.out.println("remove: " + myQueue.remove());
        System.out.println("size: " + myQueue.size());
        System.out.println("remove: " + myQueue.remove());
    }
}
