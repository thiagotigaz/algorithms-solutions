package br.com.supercloud.arrays;

public class AlternatingCharacters {

    // https://www.hackerrank.com/challenges/alternating-characters/problem

    static int alternatingCharacters(String s) {
        if (s.length() <= 1) {
            return 0;
        }

        int countRemoval = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                countRemoval++;
            }
        }
        return countRemoval;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAAA"));
        System.out.println(alternatingCharacters("BBBBB"));
        System.out.println(alternatingCharacters("ABABABAB"));
        System.out.println(alternatingCharacters("BABABA"));
        System.out.println(alternatingCharacters("AAABBB"));
    }
}
