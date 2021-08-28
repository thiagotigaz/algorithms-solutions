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

    public static void main(String[] args) {
        System.out.println(countPaths(1, 1));
        System.out.println(countPaths(2, 3));
        System.out.println(countPaths(3, 2));
        System.out.println(countPaths(3, 3));
        System.out.println(countPathsWithMemo(18L, 18L));
    }
}
