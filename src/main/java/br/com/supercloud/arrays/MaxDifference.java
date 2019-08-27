package br.com.supercloud.arrays;

import java.util.Arrays;
import java.util.List;

public class MaxDifference {

    /*
     * Complete the 'maxDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int maxDifference(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        if (n < 1 || n > (2 * Math.pow(10, 5))) {
            return -1;
        }
        Integer maxDiff = -1;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                int diff = arr.get(i) - arr.get(i - 1);
                maxDiff = Math.max(diff, maxDiff);
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        System.out.println(maxDifference(Arrays.asList(7, 9, 13, 5, 6, 3, 2)));
    }
}
