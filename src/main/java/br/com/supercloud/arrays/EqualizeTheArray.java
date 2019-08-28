package br.com.supercloud.arrays;

import java.util.Arrays;

public class EqualizeTheArray {

    // https://www.hackerrank.com/challenges/equality-in-a-array

    static int equalizeArray(int[] arr) {
        int[] frequency = new int[Arrays.stream(arr).max().getAsInt() + 1];
        int maxFreqIndex = 0;
        for (int i : arr) {
            frequency[i]++;
            if (frequency[i] > frequency[maxFreqIndex]) {
                maxFreqIndex = i;
            }
        }
        return arr.length - frequency[maxFreqIndex];
    }

    public static void main(String[] args) {
        int minDeletion = equalizeArray(new int[]{3, 3, 2, 1, 3});
        System.out.println(minDeletion);
    }
}
