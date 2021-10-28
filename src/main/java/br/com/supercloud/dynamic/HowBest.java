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

    public static List<Integer> howBestTabulation(int targetSum, int[] numbers) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= targetSum+1; i++) {
            result.add(null);
        }
        result.set(0, new ArrayList<>());
        for (int i = 0; i <= targetSum; i++) {
            List<Integer> curList = result.get(i);
            if (curList != null) {
                for (int n : numbers) {
                    if (i + n <= targetSum) {
                        List<Integer> nextList = result.get(i + n);
                        if (nextList == null || nextList.size() > curList.size() + 1) {
                            ArrayList<Integer> newArr = new ArrayList<>(curList);
                            newArr.add(n);
                            result.set(i + n, newArr);
                        }
                    }
                }
            }
        }
        return result.get(targetSum);
    }

    /*public static List<Integer> howBestTabulation(int targetSum, int[] numbers) {
        ArrayList<Integer>[] result = new ArrayList[targetSum + 1];
        result[0] = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++) {
            if (result[i] != null) {
                for (int n : numbers) {
                    if (i + n <= targetSum && (result[i + n] == null || result[i + n].size() > result[i].size() + 1)) {
                        ArrayList<Integer> newArr = new ArrayList<>(result[i]);
                        newArr.add(n);
                        result[i + n] = newArr;
                    }
                }
            }
        }
        return result[targetSum];
    }*/

    public static void main(String[] args) {
//        System.out.println(howBest(7, new int[]{2, 5}));
        System.out.println(howBest(7, new int[]{5, 3, 4, 7}));
//        System.out.println(howBest(7, new int[]{2, 3}));
//        System.out.println(howBest(7, new int[]{5, 3, 4, 7}));
//        System.out.println(howBest(7, new int[]{2, 4}));
        System.out.println(howBest(8, new int[]{2, 3, 5}));
        System.out.println(howBest(8, new int[]{1, 4, 5}));
        System.out.println(howBestWithMemo(100, new int[]{1, 2, 5, 25}, new HashMap<>()));

        System.out.println(howBestTabulation(7, new int[]{5, 3, 4, 7}));
        System.out.println(howBestTabulation(8, new int[]{2, 3, 5}));
        System.out.println(howBestTabulation(8, new int[]{1, 4, 5}));
        System.out.println(howBestTabulation(100, new int[]{1, 2, 5, 25}));
    }
}
