package br.com.supercloud.arrays;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 7, 8, 6, 3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int[] aux, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, aux, start, middle);
            mergeSort(arr, aux, middle + 1, end);
            mergeHalves(arr, aux, start, middle, end);
        }
    }

    private static void mergeHalves(int[] arr, int[] aux, int start, int middle, int end) {
        System.arraycopy(arr, start, aux, start, end - start + 1);
        int leftIdx = start;
        int rightIdx = middle + 1;
        for (int i = start; i <= end; i++) {
            if (leftIdx > middle) { // filled all lefts, so fill remaining rights
                arr[i] = aux[rightIdx++];
            } else if (rightIdx > end) { // filled all rights, so fill remaining lefts
                arr[i] = aux[leftIdx++];
            } else if (aux[leftIdx] <= aux[rightIdx]) {
                arr[i] = aux[leftIdx++];
            } else {
                arr[i] = aux[rightIdx++];
            }
        }
    }


}
