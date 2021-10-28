package br.com.supercloud.dynamic;

import java.util.*;

public class HowSum {


    public static void main(String[] args) {
        System.out.println(howSumTabulation(7, new int[]{2, 3}));
        System.out.println(howSumTabulation(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSumTabulation(7, new int[]{2, 4}));
        System.out.println(howSumTabulation(8, new int[]{2, 3, 5}));
        System.out.println();

        System.out.println(howSum(7, new int[]{2, 3}));
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(howSum(7, new int[]{2, 4}));
        System.out.println(howSum(8, new int[]{2, 3, 5}));
        System.out.println();
//        System.out.println(howSumWithMemo(7, new int[]{2, 3}));
//        System.out.println(howSumWithMemo(7, new int[]{5, 3, 4, 7}));
//        System.out.println(howSumWithMemo(7, new int[]{2, 4}));
//        System.out.println(howSumWithMemo(8, new int[]{2, 3, 5}));
//        System.out.println(howSumWithMemo(3000, new int[]{7, 14, 100}));
    }

    private static List<Integer> howSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;
        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    private static List<Integer> howSumWithMemo(int targetSum, int[] numbers) {
        return howSumWithMemo(targetSum, numbers, new HashMap<>());
    }

    private static List<Integer> howSumWithMemo(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new LinkedList<>();
        if (targetSum < 0) return null;
        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSumWithMemo(remainder, numbers, memo);
            if (remainderResult != null) {
                remainderResult.add(num);
                memo.put(targetSum, remainderResult);
                return remainderResult;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    private static List<Integer> howSumTabulation(int targetSum, int[] numbers) {
        ArrayList<Integer>[] result = new ArrayList[targetSum + 1];
        result[0] = new ArrayList<>();
        for (int i = 0; i <= targetSum; i++) {
            if (result[i] != null) {
                for (int n : numbers) {
                    if (i + n < result.length) {
                        ArrayList<Integer> newArr = new ArrayList<>(result[i].size() + 1);
                        newArr.addAll(result[i]);
                        newArr.add(n);
                        result[i + n] = newArr;
                    }
                }
            }
        }
        return result[targetSum];
    }
}
