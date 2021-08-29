package br.com.supercloud.dynamic;

import java.util.*;

public class HowBest {

    public static List<Integer> howBest(int targetSum, int[] numbers) {
        if (targetSum == 0) return new LinkedList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;
        for (int n : numbers) {
            int remainder = targetSum - n;
            List<Integer> howBestResult = howBest(remainder, numbers);
            if (howBestResult != null) {
                howBestResult.add(n);
                if (shortestCombination == null || howBestResult.size() < shortestCombination.size()) {
                    shortestCombination = howBestResult;
                }
            }
        }
        return shortestCombination;
    }

    public static List<Integer> howBestWithMemo(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new LinkedList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;
        for (int n : numbers) {
            int remainder = targetSum - n;
            List<Integer> howBestResult = howBestWithMemo(remainder, numbers, memo);
            if (howBestResult != null) {
                howBestResult = new LinkedList<>(howBestResult);
                howBestResult.add(n);
                if (shortestCombination == null || howBestResult.size() < shortestCombination.size()) {
                    shortestCombination = howBestResult;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }

    public static void main(String[] args) {
//        System.out.println(howBest(7, new int[]{2, 5}));
        System.out.println(howBest(7, new int[]{5, 3, 4, 7}));
//        System.out.println(howBest(7, new int[]{2, 3}));
//        System.out.println(howBest(7, new int[]{5, 3, 4, 7}));
//        System.out.println(howBest(7, new int[]{2, 4}));
        System.out.println(howBest(8, new int[]{2, 3, 5}));
        System.out.println(howBest(8, new int[]{1, 4, 5}));
        System.out.println(howBestWithMemo(100, new int[]{1, 2, 5, 25}, new HashMap<>()));
    }
}
