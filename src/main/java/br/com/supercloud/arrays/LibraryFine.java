package br.com.supercloud.arrays;

public class LibraryFine {

    // https://www.hackerrank.com/challenges/library-fine/problem

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 != y2) {
            return y1 > y2 ? 10000 : 0;
        } else if (m1 != m2) {
            return m1 > m2 ? (m1 - m2) * 500 : 0;
        } else if (d1 > d2) {
            return (d1 - d2) * 15;
        }
        return 0;
    }

}
