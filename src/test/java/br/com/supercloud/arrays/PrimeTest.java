package br.com.supercloud.arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import br.com.supercloud.arrays.Prime;
import org.junit.Test;

public class PrimeTest {

    private final Prime prime = new Prime();

    @Test
    public void isPrime() {
        assertFalse(prime.isPrime(1));
        assertFalse(prime.isPrime(4));
        assertFalse(prime.isPrime(6));
        assertFalse(prime.isPrime(8));
        assertFalse(prime.isPrime(10));
        assertFalse(prime.isPrime(12));
        assertFalse(prime.isPrime(15));
        assertTrue(prime.isPrime(2));
        assertTrue(prime.isPrime(3));
        assertTrue(prime.isPrime(5));
        assertTrue(prime.isPrime(11));
        assertTrue(prime.isPrime(17));
    }

    @Test
    public void sieveOfEratosthenes() {
        boolean[] booleans = prime.sieveOfEratosthenes(25);
        assertFalse(booleans[1]);
        assertFalse(booleans[4]);
        assertFalse(booleans[6]);
        assertFalse(booleans[8]);
        assertFalse(booleans[10]);
        assertFalse(booleans[12]);
        assertFalse(booleans[15]);
        assertTrue(booleans[2]);
        assertTrue(booleans[3]);
        assertTrue(booleans[5]);
        assertTrue(booleans[11]);
        assertTrue(booleans[17]);
    }

}
