package br.com.supercloud.arrays;

import java.util.Arrays;

public class MiniMaxSum {

    // https://www.hackerrank.com/challenges/mini-max-sum/problem

    static void miniMaxSum(int[] arr) {
        long sum = Arrays.stream(arr).asLongStream().sum();
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println((sum - max) + " " + (sum - min));
    }
}
