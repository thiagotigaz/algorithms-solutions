package br.com.supercloud.sort;

import java.util.Arrays;
import java.util.List;

public class InsertionSort2 {

    // https://www.hackerrank.com/challenges/insertionsort2/problem
    private static void insertionSort(int n, List<Integer> arr) {
        int aux;
        for (int i = n - 1; i > 0; i--) {
            aux = arr.get(i);
            if (arr.get(i - 1) > aux) {
                arr.set(i, arr.get(i - 1));
                arr.set(i - 1, aux);
            }
        }
    }

    private static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1; i < n; i++) {
            Integer last = arr.get(i - 1);
            Integer cur = arr.get(i);
            if (last > cur) {
                insertionSort(i + 1, arr);
            }
            print(arr);
        }
    }

    private static void print(List<Integer> arr) {
        arr.forEach(num -> System.out.printf("%d ", num));
        System.out.println();
    }

    public static void main(String[] args) {
        insertionSort2(6, Arrays.asList(1, 4, 3, 5, 6, 2));
        insertionSort2(10, Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 1));
    }


}
