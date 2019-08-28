package br.com.supercloud.arrays;

public class ArrayManipulation {

    // https://www.hackerrank.com/challenges/crush/problem

    static long arrayManipulation(int n, int[][] queries) {
        long max = Long.MIN_VALUE;
        long[] sumArr = new long[n];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            sumArr[a - 1] += k;
            if (b < sumArr.length) {
                sumArr[b] -= k;
            }
        }

        max = Math.max(max, sumArr[0]);
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] += sumArr[i - 1];
            max = Math.max(max, sumArr[i]);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(arrayManipulation(4, new int[][]{
                {2, 3, 603},
                {1, 1, 286},
                {4, 4, 882}
        }));

        System.out.println(arrayManipulation(5, new int[][]{
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        }));

        System.out.println(arrayManipulation(4, new int[][]{
                {2, 3, 603},
                {1, 1, 286},
                {4, 4, 882}
        }));
    }
}
