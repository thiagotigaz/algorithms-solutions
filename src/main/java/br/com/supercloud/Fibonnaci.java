package br.com.supercloud;

public class Fibonnaci {

    public static int fibRecursive(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return fibRecursive(n - 1) + fibRecursive(n - 2);
        }
    }

    public static int fib(int n) {
        int current = 1, last = 0;
        for (int i = 0; i < n; i++) {
            int aux = current;
            current = last + current;
            last = aux;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fibRecursive(6));
        System.out.println(fib(6));
    }
}
