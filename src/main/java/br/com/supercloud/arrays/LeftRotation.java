package br.com.supercloud.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        if (a.size() == d) return a;
        List<Integer> result = new ArrayList<>();
        int n = a.size();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - d) {
                result.add(a.get(i + d));
            } else {
                result.add(a.get(idx));
                idx++;
            }
        }
        return result;
    }

    public static int[] rotLeft2(int[] arr, int d) {
        if (arr.length == d) return arr;
        int[] aux = new int[d];
        System.arraycopy(arr, 0, aux, 0, d);
        int auxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - d) {
                arr[i] = arr[i + d];
            } else {
                arr[i] = aux[auxIdx++];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        int[] result = rotLeft(new int[]{1, 2, 3, 4, 5}, 4);
        int[] result = rotLeft2(new int[]{1, 2, 3, 4, 5}, 4);
        Arrays.stream(result).forEach(System.out::println);
    }
}
