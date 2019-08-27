package br.com.supercloud.arrays;

public class Prime {

    boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];
        init(flags);

        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            // Cross of all remaining multiples of prime
            crossoff(flags, prime);
            prime = getNextPrime(flags, prime);
        }
        return flags;
    }

    private void crossoff(boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    private int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    private void init(boolean[] flags) {
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
    }

    public static void main(String[] args) {
        boolean[] booleans = new Prime().sieveOfEratosthenes(500);
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                System.out.println(i);
            }
        }
    }

}
