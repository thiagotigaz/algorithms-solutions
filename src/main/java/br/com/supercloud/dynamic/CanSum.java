package br.com.supercloud.dynamic;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));

        System.out.println();
        System.out.println(canSumTabulation(7, new int[]{2, 3}));
        System.out.println(canSumTabulation(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSumTabulation(7, new int[]{2, 4}));
        System.out.println(canSumTabulation(8, new int[]{2, 3, 5}));
        System.out.println(canSumTabulation(300, new int[]{7, 14}));
//        System.out.println(canSumWithMemo(3000, new int[]{7, 14}));
    }

    private static boolean canSum(int targetSum, int[] numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int number : numbers) {
            int remainder = targetSum - number;
            if (canSum(remainder, numbers)) {
                return true;
            }
        }
        return false;
    }

    private static boolean canSumWithMemo(int targetSum, int[] numbers) {
        return canSumWithMemo(targetSum, numbers, new HashMap<>());
    }

    private static boolean canSumWithMemo(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;
        for (int number : numbers) {
            int remainder = targetSum - number;
            if (canSumWithMemo(remainder, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    private static boolean canSumTabulation(int targetSum, int[] numbers) {
        boolean[] result = new boolean[targetSum + 1];
        result[0] = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                for (int n : numbers) {
                    if (i + n < result.length) {
                        result[i + n] = true;
                    }
                }
            }
        }
        return result[targetSum];
    }
}
