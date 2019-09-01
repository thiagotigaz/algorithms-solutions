package br.com.supercloud.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    // https://www.hackerrank.com/challenges/count-triplets-1/problem

    static long countTriplets(List<Long> arr, long r) {
        if (arr.size() <= 1) {
            return 0L;
        }
        Map<Long, Long> t2 = new HashMap<>();
        Map<Long, Long> t3 = new HashMap<>();
        long countTriplets = 0L;
        for (Long n : arr) {
            // if n exists in t3 map, it means that first value was added in t2 and then it matched the if and was added
            // to t3 map.
            countTriplets += t3.getOrDefault(n, 0L);
            // If n is present in t2 it means that it was added before
            Long key = n * r;
            if (t2.containsKey(n)) {
                // Add t3 value of n multiplying by r with either 0 + 1 occurances or previous value + 1
                t3.put(key, t3.getOrDefault(key, 0L) + t2.get(n));
            }
            // First we add the second value
            t2.put(key, t2.getOrDefault(key, 0L) + 1L);
        }

        return countTriplets;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5));
    }

}
