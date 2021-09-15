package br.com.supercloud.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort2 {
    // https://www.hackerrank.com/challenges/quicksort2/problem
    /*public static List<Integer> quickSort(List<Integer> arr) {
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
    }*/
    /*public static int partition(List<Integer> arr, int begin, int end) {
        int pivot = arr.get(end);
        System.out.println("arr = " + arr + ", begin = " + begin + ", end = " + end + ", pivot = " + pivot);
        int idx = (begin-1);
        for (int i = begin; i < end; i++) {
            System.out.println("idx = " + idx + ", i = " + i);
            if (arr.get(i) <= pivot) {
                idx++;
                System.out.println("swapping idx = " + idx + " with i = " + i);
                int swapTemp = arr.get(idx);
                arr.set(idx, arr.get(i));
                arr.set(i, swapTemp);
            }
        }
        int swapTemp = arr.get(idx + 1);
        arr.set(idx + 1, arr.get(end));
        arr.set(end, swapTemp);

        return idx+1;
    }*/

    public static int partition(List<Integer> arr, int begin, int end) {
        int pivot = arr.get(end);
        int idx = begin - 1;
        for (int i = begin; i < end; i++) {
            Integer cur = arr.get(i);
            if (cur < pivot) {
                idx++;
                swap(arr, i, idx);
            }
        }
        idx++;
        swap(arr, idx, end);
        return idx ;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        Integer tmp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, tmp);
    }

    /*public static int partition(List<Integer> arr, int begin, int end) {
        int pivot = arr.get(begin);
        int idx = begin;
        int pivotIdx = begin;
        for (int i = begin; i <= end; i++) {
            Integer cur = arr.get(i);
            if (cur < pivot) {
                Integer tmp = arr.get(idx);
                arr.set(idx, cur);
                arr.set(i, tmp);
                if(tmp == pivot) {
                    pivotIdx = i;
                }
                idx++;
            }
        }
        Integer tmp = arr.get(idx);
        arr.set(idx, pivot);
        arr.set(pivotIdx, tmp);
        return idx;
    }*/

    // 5, 8, 1, 3, 7, 9, 2
    // 1, 8, 5, 3, 7, 9, 2
    // 1, 3, 5, 8, 7, 9, 2
    
    private static List<Integer> quicksort(List<Integer> arr, int begin, int end) {
        if (begin < end) {
            int partition = partition(arr, begin, end);
            quicksort(arr, begin, partition - 1);
            quicksort(arr, partition + 1, end);
        }
        return arr;
    }
    /*public static List<Integer> quickSort2(List<Integer> arr) {
        System.out.println("arr = " + arr);
        if (arr.size() < 2) {
            return arr;
        } else if (arr.size() == 2) {
            return arr.get(0) < arr.get(1) ? arr : new ArrayList<>(Arrays.asList(arr.get(1), arr.get(0)));
        } else {
            int mid = arr.size() / 2;
            List<Integer> left = quickSort2(arr.subList(0, mid));
            List<Integer> right = quickSort2(arr.subList(mid, arr.size()));
            int n = left.size() + right.size();
            List<Integer> result = new ArrayList<>(n);
            int lIdx = 0;
            int rIdx = 0;
            for (int i = 0; i < n; i++) {
                if (lIdx < left.size() && left.get(lIdx) < right.get(rIdx)) {
                    result.add(left.get(lIdx++));
                } else {
                    result.add(right.get(rIdx++));
                }
            }
            return result;
        }
    }*/

    public static void main(String[] args) {
        System.out.println(quicksort(Arrays.asList(5, 8, 1, 3, 7, 9, 2), 0, 6));
    }
}
