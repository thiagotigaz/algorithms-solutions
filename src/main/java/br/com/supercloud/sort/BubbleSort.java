package br.com.supercloud.sort;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void countSwaps(List<Integer> arr) {
        int totalSwaps = 0;
        for (int i = 0; i < arr.size(); i++) {
            int interationSwaps = 0;
            for (int j = 0; j < arr.size() - 1; j++) {
                Integer a = arr.get(j);
                Integer b = arr.get(j + 1);
                if (a > b) {
                    arr.set(j, b);
                    arr.set(j + 1, a);
                    totalSwaps++;
                    interationSwaps++;
                }
            }
            if (interationSwaps == 0) {
                break;
            }
        }
        System.out.println(String.format("Array is sorted in %d swaps.", totalSwaps));
        System.out.println(String.format("First Element: %d", arr.get(0)));
        System.out.println(String.format("Last Element: %d", arr.get(arr.size() - 1)));
    }

    public static void main(String[] args) {
        countSwaps(Arrays.asList(3, 2, 1));
    }
}
