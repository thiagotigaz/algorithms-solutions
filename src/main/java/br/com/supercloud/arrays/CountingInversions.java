package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.List;

public class CountingInversions {
    // https://www.hackerrank.com/challenges/ctci-merge-sort
    public static long countInversions(List<Integer> arr) {
        // Write your code here
        int[] ints = arr.stream().mapToInt((i) -> i).toArray();
        long swaps = mergeSortCount(ints, new int[ints.length], 0, ints.length - 1);
        return swaps;
    }

    private static long mergeSortCount(int[] arr, int[] aux, int from, int to) {
        if (from >= to) {
            return 0;
        }
        int mid = from + (to - from) / 2;
        long count = 0L;
        count += mergeSortCount(arr, aux, from, mid);
        count += mergeSortCount(arr, aux, mid + 1, to);
        count += merge(arr, aux, from, mid, to);
        return count;
    }

    private static long merge(int[] arr, int[] aux, int from, int mid, int to) {
        System.arraycopy(arr, from, aux, from, to - from + 1);
        long swaps = 0L;
        int i = from, j = mid + 1;
        for (int k = from; k <= to; k++) {
            if (i > mid) { // filled all lefts, so add from remaining rights
                arr[k] = aux[j++];
            } else if (j > to) { // filled all rights, so add from remaining lefts
                arr[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
                swaps += mid - i + 1;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        System.out.println(countInversions(Arrays.asList(1, 1, 1, 2, 2))); // 0
        System.out.println(countInversions(Arrays.asList(2, 1, 3, 1, 2))); // 4
        System.out.println(countInversions(Arrays.asList(5, 4, 3, 2, 1))); // 10
    }
}
