package br.com.supercloud;

public class Fibonnaci {

    public static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            int aux = cur;
            cur += last;
            last = aux;
        }
        return cur;
    }

    static int fibDynamic(int n) {
        if (n <= 1) {
            return n;
        }
        int[] f = new int[n + 1]; // 1 extra to handle case, n = 0
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(fibRecursive(7));
        System.out.println(fib(7));
        System.out.println(fibDynamic(7));
    }
}
