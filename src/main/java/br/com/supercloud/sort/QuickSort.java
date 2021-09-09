package br.com.supercloud.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort {
    // https://www.hackerrank.com/challenges/quicksort1/problem
    public static List<Integer> quickSort(List<Integer> arr) {
        int pivot = arr.get(0);
        List<Integer> left = new ArrayList<>(arr.size());
        List<Integer> right = new LinkedList<>();
        for (Integer n : arr) {
            if (n < pivot) {
                left.add(n);
            } else {
                right.add(n);
            }
        }
        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        System.out.println(quickSort(Arrays.asList(4, 5, 3, 7, 2)));
    }
}
