package br.com.supercloud.arrays;

public class CountingValleys {

    // https://www.hackerrank.com/challenges/counting-valleys/problem

    private static final char DOWN_STEP = 'D';
    private static final char UP_STEP = 'U';

    static int countingValleys(int n, String s) {
        int countValleys = 0;
        int seaLevel = 0;
        for (char c : s.toCharArray()) {
            if (c == DOWN_STEP) {
                seaLevel--;
            } else {
                seaLevel++;
            }
            // This means we just came back from a valley to sea level
            if (c == UP_STEP && seaLevel == 0) {
                countValleys++;
            }
        }
        return countValleys;
    }

    public static void main(String[] args) {
        int countValleys = countingValleys(10, "DUDDDUUDUU");
        System.out.println(countValleys);
    }

}
