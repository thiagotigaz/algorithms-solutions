package br.com.supercloud.queues;

import java.util.Deque;
import java.util.LinkedList;

public class BalancedBrackets {
    // https://www.hackerrank.com/challenges/balanced-brackets
    public static String isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return "NO";
        }
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (isOpenBracket(c)) {
                queue.push(c);
            } else if (queue.isEmpty() || !isMatchingCloseBracket(queue.pop(), c)) {
                return "NO";
            }
        }
        return queue.isEmpty() ? "YES" : "NO";
    }

    private static boolean isMatchingCloseBracket(Character open, char close) {
        return (open == '{' && close == '}')
                || (open == '[' && close == ']')
                || (open == '(' && close == ')');
    }

    private static boolean isOpenBracket(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}")); // YES
        System.out.println(isBalanced("{[(])}")); // NO
        System.out.println(isBalanced("{{[[(())]]}}")); // YES
    }
}
