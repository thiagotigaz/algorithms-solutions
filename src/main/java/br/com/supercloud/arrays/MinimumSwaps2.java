package br.com.supercloud.arrays;

public class MinimumSwaps2 {

    // https://www.hackerrank.com/challenges/minimum-swaps-2/problem

    static int minimumSwaps(int[] arr) {
        int[] temp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]] = i;
        }

        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                swaps++;
                int tmp = arr[i];
                arr[i] = i + 1;
                arr[temp[i + 1]] = tmp;
                temp[tmp] = temp[i + 1];
            }
        }
        return swaps;
    }


    public static void main(String[] args) {
        int minimumSwaps = minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6});
        System.out.println(minimumSwaps); // minimumSwaps should be 5
    }
}
