package br.com.supercloud;

import java.util.HashMap;
import java.util.Map;

public class Fibonnaci {

    public static int fibRecursive(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static Long fibRecursiveWithMemo(int n) {
        Map<Integer, Long> memo = new HashMap<>();
        return fibRecursiveWithMemo(n, memo);
    }

    public static Long fibRecursiveWithMemo(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 2) {
            return 1L;
        }
        memo.put(n, fibRecursiveWithMemo(n - 1, memo) + fibRecursiveWithMemo(n - 2, memo));
        return memo.get(n);
    }

    public static long fib(int n) {
        if (n <= 2) {
            return 1;
        }
        long last = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            long aux = cur;
            cur += last;
            last = aux;
        }
        return cur;
    }

    static long fibDynamic(int n) {
        if (n <= 2) {
            return 1;
        }
        long[] f = new long[n + 1]; // 1 extra to handle case, n = 0
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    static long fibTabulation(int n) {
        if (n <= 2) {
            return 1;
        }
        long[] f = new long[n + 1]; // 1 extra to handle case, n = 0
        f[1] = 1;

        for (int i = 0; i < n; i++) {
            f[i + 1] += f[i];
            if (i < n - 1)
                f[i + 2] = f[i];
        }

        return f[n];
    }

    public static void main(String[] args) {
        /*System.out.println(fibRecursive(7));
        System.out.println(fibRecursive(8));
        // System.out.println(fibRecursive(50)); This is undoable due to the 2 to the n time complexity
        System.out.println(fibRecursiveWithMemo(7));
        System.out.println(fibRecursiveWithMemo(8));
        System.out.println(fibRecursiveWithMemo(50));
        System.out.println(fib(7));
        System.out.println(fib(8));
        System.out.println(fib(50));
        System.out.println(fibDynamic(7));
        System.out.println(fibDynamic(8));
        System.out.println(fibDynamic(50));*/
        System.out.println(fibTabulation(6));
        System.out.println(fibTabulation(7));
        System.out.println(fibTabulation(8));
        System.out.println(fibTabulation(50));
    }
}
