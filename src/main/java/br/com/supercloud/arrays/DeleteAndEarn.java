package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteAndEarn {

    public static long maxPoints(List<Integer> elements) {
        int maxElement = elements.stream().max(Integer::compare).get();
        if (maxElement == 0) {
            return 0;
        }
        Map<Integer, Integer> elementsFrequency = buildFrequencyMap(elements);
        int[] dp = new int[maxElement + 1];
        dp[0] = 0;
        dp[1] = getProduct(1, elementsFrequency);
        for (int i = 2; i < dp.length; i++) {
            int product = getProduct(i, elementsFrequency);
            dp[i] = Math.max(dp[i - 1], product + dp[i - 2]);
        }
        return dp[maxElement];
    }

    private static int getProduct(int n, Map<Integer, Integer> elementsFrequency) {
        if (elementsFrequency.containsKey(n)) {
            return n * elementsFrequency.get(n);
        }
        return 0;
    }

    private static Map<Integer, Integer> buildFrequencyMap(List<Integer> elements) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i : elements) {
            if (frequency.containsKey(i)) {
                int curValue = frequency.get(i);
                frequency.put(i, curValue + 1);
            } else {
                frequency.put(i, 1);
            }
        }
        return frequency;
    }

    public static void main(String[] args) {
        long maxPoints = maxPoints(Arrays.asList(3, 4, 2, 10, 8, 11));
        System.out.println(maxPoints);
    }

}
