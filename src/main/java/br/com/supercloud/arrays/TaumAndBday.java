package br.com.supercloud.arrays;

public class TaumAndBday {

    // https://www.hackerrank.com/challenges/taum-and-bday/problem

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        long blackCost = Math.min(bc, wc + z);
        long whiteCost = Math.min(wc, bc + z);
        return (b * blackCost) + (w * whiteCost);
    }

    public static void main(String[] args) {
        long totalCost = taumBday(3, 6, 9, 1, 1);
        System.out.println(totalCost);
    }
}
