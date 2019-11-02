package br.com.supercloud.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CutTheSticks {

    // https://www.hackerrank.com/challenges/cut-the-sticks/problem

    static int[] cutTheSticks(int[] arr) {
        List<Integer> sticksToCut = new LinkedList<>();
        while (arr.length > 1) {
            arr = Arrays.stream(arr).filter(x -> x > 0).toArray();
            if (arr.length > 0) {
                sticksToCut.add(arr.length);
                int cutLength = Arrays.stream(arr).min().getAsInt();
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i] - cutLength;
                }
            }
        }
        return sticksToCut.stream().mapToInt(i -> i).toArray();
    }

    static int[] cutTheSticks2(int[] arr) {
        int[] freqArray = new int[1001];
        for (int i : arr) {
            freqArray[i]++;
        }
        List<Integer> sticksToCut = new ArrayList<>();
        sticksToCut.add(arr.length);
        for (int i : freqArray) {
            if (i != 0) {
                i = sticksToCut.get(sticksToCut.size() - 1) - i;
                if (i != 0) {
                    sticksToCut.add(i);
                }
            }
        }
        return sticksToCut.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] ints = cutTheSticks2(new int[]{5, 4, 4, 2, 2, 8});
        Arrays.stream(ints).forEach(System.out::println); // 6 4 2 1
        ints = cutTheSticks2(new int[]{8, 8, 14, 10, 3, 5, 14, 12});
        Arrays.stream(ints).forEach(System.out::println); // 8 7 6 4 3 2
    }

}
