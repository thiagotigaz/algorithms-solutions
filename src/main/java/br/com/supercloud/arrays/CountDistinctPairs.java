package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountDistinctPairs {

    public static void main(String[] args) {
//        System.out.println(countPairs(1, Arrays.asList(1, 1, 1, 2))); // 1
//        System.out.println(countPairs(2, Arrays.asList(1, 3, 1, 2))); // 1
//        System.out.println(countPairs(2, Arrays.asList(1, 3, 2, 4))); // 2
//        System.out.println(countPairs(2, Arrays.asList(1, 3, 2, 4, 5, 7))); // 4

        System.out.println(hasSum(3, Arrays.asList(1, 2))); // 1
        System.out.println(hasSum(1, Arrays.asList(1, 1, 1, 2))); // 0
        System.out.println(hasSum(2, Arrays.asList(1, 3, 1, 2))); // 1
        System.out.println(hasSum(4, Arrays.asList(1, 3, 2, 4, 2))); // 2
        System.out.println(hasSum(4, Arrays.asList(1, 3, 2, 4, 5, 7))); // 1
        System.out.println(hasSum(5, Arrays.asList(1, 3, 2, 4, 5, 7))); // 2
    }

    private static long countPairs(int k, List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.stream().filter(a -> uniqueNumbers.contains(a + k)).count();
    }

    private static long hasSum(int k, List<Integer> numbers) {
        int result = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                Integer a = numbers.get(i);
                Integer b = numbers.get(j);
                if ((a + b) == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
