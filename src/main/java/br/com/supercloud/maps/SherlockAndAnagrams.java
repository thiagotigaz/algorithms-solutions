package br.com.supercloud.maps;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

    // https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        int totalAnagrams = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = sorted(s.substring(i, j));
                totalAnagrams += wordFrequency.merge(substring, 1, Integer::sum) - 1;
            }
        }
        return totalAnagrams;
    }

    private static String sorted(String s) {
        return s.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba")); // a,a / ab, ba/ b,b / abb,bba
        System.out.println(sherlockAndAnagrams("abcd"));
        System.out.println(sherlockAndAnagrams("kkkk"));
    }
}
