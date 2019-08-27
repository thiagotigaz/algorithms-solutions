package br.com.supercloud.arrays;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        boolean[] containedLetters = new boolean[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : s1.toCharArray()) {
            int n = getCharNumber(c);
            if (n != -1) {
                containedLetters[n] = true;
            }
        }

        for (char c : s2.toCharArray()) {
            int n = getCharNumber(c);
            if (n != -1 && containedLetters[n]) {
                return "YES";
            }
        }
        return "NO";
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
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }

}
