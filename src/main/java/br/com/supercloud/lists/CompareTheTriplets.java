package br.com.supercloud.lists;

import java.util.Arrays;
import java.util.List;

public class CompareTheTriplets {

    // https://www.hackerrank.com/challenges/compare-the-triplets/problem

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aTotal = 0;
        int bTotal = 0;
        for (int i = 0; i < a.size(); i++) {
            int aScore = a.get(i);
            int bScore = b.get(i);
            if (aScore > bScore) {
                aTotal++;
            } else if (aScore < bScore) {
                bTotal++;
            }
        }
        return Arrays.asList(aTotal, bTotal);
    }

}
