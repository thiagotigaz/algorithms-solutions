package br.com.supercloud.arrays;

import java.util.Arrays;

public class GreedyFlorist {
    // https://www.hackerrank.com/challenges/greedy-florist
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int totalFlowers = c.length;
        if (k >= totalFlowers) {
            return Arrays.stream(c).sum();
        }
        int minCost = 0;
        for (int i = totalFlowers - 1; i >= 0; i--) {
            if (totalFlowers - i <= k) {
                minCost += c[i];
            } else {
                int idx = totalFlowers - i - k;
                int aux = idx % k == 0 ? idx / k + 1 : idx / k + 2;
                minCost += c[i] * aux;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumCost(3, new int[]{2, 5, 6})); // 13
        System.out.println(getMinimumCost(2, new int[]{2, 5, 6})); // 15
        System.out.println(getMinimumCost(3, new int[]{1, 3, 5, 7, 9})); // 29
        System.out.println(getMinimumCost(3, new int[]{
                390225, 426456, 688267, 800389, 990107, 439248, 240638, 15991, 874479, 568754, 729927, 980985, 132244, 488186, 5037, 721765, 251885, 28458, 23710, 281490, 30935, 897665, 768945, 337228, 533277, 959855, 927447, 941485, 24242, 684459, 312855, 716170, 512600, 608266, 779912, 950103, 211756, 665028, 642996, 262173, 789020, 932421, 390745, 433434, 350262, 463568, 668809, 305781, 815771, 550800
        })); // 163578911
    }
}
