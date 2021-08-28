package br.com.supercloud.arrays;

import java.util.Arrays;

public class Cafeteria {

    public static long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);
        long extraSpaces = getSpacesBetween(K, 1, S[0], true);
        if (M == 1) {
            return extraSpaces + getSpacesBetween(K, S[0], N, true);
        }
        for (int i = 0; i < M - 1; i++) {
            extraSpaces += getSpacesBetween(K, S[i], S[i + 1], false);
        }
        extraSpaces += getSpacesBetween(K, S[M - 1], N, true);

        return extraSpaces;
    }

    private static long getSpacesBetween(long K, long start, long end, boolean inclusive) {
        long spacesBtw = end - start;
        if (spacesBtw > K) {
            long availableSpaces = spacesBtw / (K + 1);
            return inclusive ? availableSpaces : availableSpaces - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getMaxAdditionalDinersCount(10, 1, 1, new long[]{5})); // 4
        System.out.println(getMaxAdditionalDinersCount(10, 1, 2, new long[]{2, 6})); // 3
        System.out.println(getMaxAdditionalDinersCount(15, 2, 3, new long[]{11, 6, 14})); // 1
    }
}
