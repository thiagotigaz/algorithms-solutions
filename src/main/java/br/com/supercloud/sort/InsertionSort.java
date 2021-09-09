package br.com.supercloud.sort;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {

    // https://www.hackerrank.com/challenges/insertionsort1/problem
    public static void insertionSort(int n, List<Integer> arr) {
        Integer last = arr.get(n - 1);
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && arr.get(i - 1) >= last) {
                arr.set(i, arr.get(i - 1));
                print(arr);
            } else {
                arr.set(i, last);
                break;
            }
        }
        print(arr);
    }

    private static void insertionSort2(int n, List<Integer> arr) {
        int aux;
        for (int i = n - 1; i > 0; i--) {
            aux = arr.get(i);
            if (arr.get(i - 1) > aux) {
                arr.set(i, arr.get(i - 1));
                print(arr);
                arr.set(i - 1, aux);
            }
        }
        print(arr);
    }

    private static void print(List<Integer> arr) {
        arr.forEach(num -> System.out.printf("%d ", num));
        System.out.println();
    }

    public static void main(String[] args) {
//        insertionSort(5, Arrays.asList(1, 2, 4, 5, 3));
//        insertionSort2(5, Arrays.asList(2, 4, 6, 8, 3));
        insertionSort2(10, Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 1));
    }


}
