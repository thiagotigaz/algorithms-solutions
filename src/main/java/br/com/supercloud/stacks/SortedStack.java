package br.com.supercloud.stacks;

import java.util.Stack;

public class SortedStack {

    Stack<Integer> stack = new Stack<>();

    boolean isEmpty() {
        return stack.isEmpty();
    }

    void push(int value) {
        if (stack.isEmpty() || value <= peek()) {
            stack.push(value);
        } else {
            Stack<Integer> aux = new Stack<>();
            while (!stack.isEmpty() && stack.peek() < value) {
                aux.push(stack.pop());
            }
            stack.push(value);
            while (!aux.isEmpty()) {
                stack.push(aux.pop());
            }
        }
    }

    Integer peek() {
        return stack.peek();
    }

    Integer pop() {
        return stack.pop();
    }

    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(5);
        sortedStack.push(4);
        sortedStack.push(2);
        sortedStack.push(4);
        sortedStack.push(1);
        sortedStack.push(3);
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.pop());
        sortedStack.push(2);
        sortedStack.push(1);
        sortedStack.push(10);

        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.peek());
        System.out.println(sortedStack.pop());
        System.out.println(sortedStack.pop());
    }
}
