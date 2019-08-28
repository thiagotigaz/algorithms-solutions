package br.com.supercloud.arrays;

import java.util.Arrays;

public class LeftRotation {

    // https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

    static int[] rotLeft(int[] a, int d) {
        int[] rotNumbers = new int[d];
        // Save numbers that will be the beginning of the array
        for (int i = 0; i < d; i++) {
            rotNumbers[i] = a[i];
        }

        // Shift the numbers in one go
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - d) {
                a[i] = a[d + i];
            } else {
                a[i] = rotNumbers[idx];
                idx++;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        int[] result = rotLeft(new int[]{1, 2, 3, 4, 5}, 4);
        Arrays.stream(result).forEach(System.out::println);
    }
}
