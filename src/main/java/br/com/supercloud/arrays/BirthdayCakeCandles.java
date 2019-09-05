package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BirthdayCakeCandles {

    // https://www.hackerrank.com/challenges/birthday-cake-candles/problem

    static int birthdayCakeCandles(int[] ar) {
        return Math.toIntExact(Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max((x, y) -> (int) (x.getValue() - y.getValue()))
                .get()
                .getValue());
    }

    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(new int[]{3, 2, 1, 3, 4, 3})); // 3
        System.out.println(birthdayCakeCandles(new int[]{1, 2, 1, 2, 2, 2})); // 4
        System.out.println(birthdayCakeCandles(new int[]{1, 2, 3, 3, 4, 4})); // 2
    }

}
