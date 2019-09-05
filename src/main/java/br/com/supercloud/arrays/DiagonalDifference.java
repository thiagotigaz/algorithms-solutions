package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    // https://www.hackerrank.com/challenges/diagonal-difference/problem

    public static int diagonalDifference(List<List<Integer>> arr) {
        int primaryDiagonal = 0;
        int secundaryDiagonal = 0;

        int n = arr.size();
        for (int i = 0; i < n; i++) {
            primaryDiagonal += arr.get(i).get(i);
            secundaryDiagonal += arr.get(i).get(n - i - 1);
        }

        return Math.abs(primaryDiagonal - secundaryDiagonal);
    }

    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        );
        System.out.println(diagonalDifference(input));
    }

}
