package br.com.supercloud.dynamic;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    static int countPaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return countPaths(m - 1, n) + countPaths(m, n - 1);
    }

    static Long countPathsWithMemo(long m, long n) {
        return countPathsWithMemo(m, n, new HashMap<>());
    }

    static Long countPathsWithMemo(long m, long n, Map<String, Long> memo) {
        String key = m + "," + n;
        String key2 = n + "," + m;
        if (memo.containsKey(key)) return memo.get(key);
        if (memo.containsKey(key2)) return memo.get(key2);
        if (m == 1 && n == 1) return 1L;
        if (m == 0 || n == 0) return 0L;
        memo.put(key, countPathsWithMemo(m - 1, n, memo) + countPathsWithMemo(m, n - 1, memo));
        return memo.get(key);
    }

    static int countPathsTabulation(int m, int n) {
        int[][] result = new int[m + 1][n + 1];
        result[1][1] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int cur = result[i][j];
                if (i + 1 <= m) result[i + 1][j] += cur;
                if (j + 1 <= n) result[i][j + 1] += cur;
            }
        }
        return result[m][n];
    }

    public static void main(String[] args) {
//        System.out.println(countPaths(1, 1)); // 1
//        System.out.println(countPaths(2, 3)); // 3
//        System.out.println(countPaths(3, 2)); // 3
//        System.out.println(countPaths(3, 3)); // 6

        System.out.println(countPathsTabulation(1, 1)); // 1
        System.out.println(countPathsTabulation(2, 3)); // 3
        System.out.println(countPathsTabulation(3, 2)); // 3
        System.out.println(countPathsTabulation(3, 3)); // 6

//        System.out.println(countPathsWithMemo(18L, 18L)); // 2333606220
    }
}
