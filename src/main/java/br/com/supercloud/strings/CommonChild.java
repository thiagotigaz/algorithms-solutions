package br.com.supercloud.strings;

import java.util.stream.IntStream;

public class CommonChild {

    // https://www.hackerrank.com/challenges/common-child/problem

    static int commonChildUsingMemoization(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        return arr[m][n];
    }

    static int commonChildUsingRecursion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        return lcs(s1, s2, m, n);
    }

    private static int lcs(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }

        return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
    }

    public static void main(String[] args) {



        System.out.println(commonChildUsingMemoization("SHINCHAN", "NOHARAAA")); // 3
        System.out.println(commonChildUsingMemoization("HARRY", "SALLY")); // 2
        System.out.println(commonChildUsingMemoization("AA", "BB")); // 0
        System.out.println(commonChildUsingMemoization("WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS",
                "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC")); // 15

        System.out.println(commonChildUsingRecursion("SHINCHAN", "NOHARAAA")); // 3
        System.out.println(commonChildUsingRecursion("HARRY", "SALLY")); // 2
        System.out.println(commonChildUsingRecursion("AA", "BB")); // 0


    }
}
