package br.com.supercloud.arrays;

public class MakeAnagram {

    // https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

    static int makeAnagram(String a, String b) {
        int numDeletes = 0;
        int[] frequency = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : a.toCharArray()) {
            int charNumber = getCharNumber(c);
            if (charNumber != -1) {
                frequency[charNumber]++;
            }
        }
        for (char c : b.toCharArray()) {
            int charNumber = getCharNumber(c);
            if (charNumber != -1) {
                frequency[charNumber]--;
            }
        }
        for (int i = 0; i < frequency.length; i++) {
            numDeletes += Math.abs(frequency[i]);
        }
        return numDeletes;
    }

    private static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("cde", "abc"));
    }
}
