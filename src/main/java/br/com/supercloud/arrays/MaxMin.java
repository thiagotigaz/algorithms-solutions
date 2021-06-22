package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxMin {
    // https://www.hackerrank.com/challenges/angry-children
    public static int maxMin(int k, List<Integer> arr) {
        Collections.sort(arr);
        int maxMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - k + 1; i++) {
            Integer min = arr.get(i);
            Integer max = arr.get(i + k - 1);
            maxMin = Math.min(maxMin, max - min);
        }
        return maxMin;
    }

    public static void main(String[] args) {
        System.out.println(maxMin(3, Arrays.asList(10, 100, 300, 200, 1000, 20, 30))); // 20
        System.out.println(maxMin(3, Arrays.asList(100, 200, 300, 350, 400, 401, 402))); // 2
    }
}
