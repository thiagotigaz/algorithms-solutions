package br.com.supercloud.arrays;

import java.util.*;

public class PowerSet {

    static void generatePowerSetWithRecursion(int[] arr,  List<List<Integer>> result, LinkedList<Integer> curSet, int n) {
        if (n == 0) {
            result.add(new LinkedList<>(curSet));
            return;
        }
        curSet.add(arr[n - 1]);
        generatePowerSetWithRecursion(arr, result, curSet, n - 1);
        curSet.removeLast();
        generatePowerSetWithRecursion(arr, result, curSet, n - 1);
    }

    static List<List<Integer>> generatePowerSet(int[] arr) {
        int n = (int) Math.pow(2, arr.length);
        List<List<Integer>> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> set = new LinkedList<>();
            for (int j = 0; j < arr.length; j++) {
                if ((i & (1 << j)) != 0) {
                    set.add(arr[j]);
                }
            }
            result.add(set);
        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(generatePowerSet(new int[]{1, 2, 3}));
        List<List<Integer>> result = new ArrayList<>();
        generatePowerSetWithRecursion(new int[]{1, 2, 3}, result, new LinkedList<>(), 3);
        System.out.println(result);
    }
}
