package br.com.supercloud.arrays;

import java.util.Arrays;

public class SockMerchant {

    // https://www.hackerrank.com/challenges/sock-merchant/problem
    
    static int sockMerchant(int n, int[] ar) {
        int maxColor = Arrays.stream(ar).map(Integer::new).max().getAsInt();
        int[] availableColors = new int[maxColor + 1];
        int countPairs = 0;
        for (int color : ar) {
            availableColors[color]++;
            if (availableColors[color] % 2 == 0) {
                countPairs++;
            }
        }
        return countPairs;
    }

    public static void main(String[] args) {
        int countPairs = sockMerchant(5, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20});
        System.out.println(countPairs);
    }
}
