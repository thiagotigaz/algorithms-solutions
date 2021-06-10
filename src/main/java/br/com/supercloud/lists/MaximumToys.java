package br.com.supercloud.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumToys {
    // https://www.hackerrank.com/challenges/mark-and-toys/problem

    public static void main(String[] args) {
        System.out.println(maximumToys(Arrays.asList(1, 12, 5, 111, 200, 1000, 10), 50));
    }

    private static int maximumToys(List<Integer> toysPrice, int budget) {
        int maxToys = 0;
        int spent = 0;
        Collections.sort(toysPrice);
        for (int i = 0; i < toysPrice.size(); i++) {
            int toyPrice = toysPrice.get(i);
            if (spent + toyPrice > budget) {
                return maxToys;
            }
            spent += toyPrice;
            maxToys++;
        }
        return maxToys;
    }
}
