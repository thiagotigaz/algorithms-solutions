package br.com.supercloud.arrays;

public class MaxArraySum {

    // https://www.hackerrank.com/challenges/max-array-sum/problem

    static int maxSubsetSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = Math.max(0, arr[0]);
        int n = arr.length;
        if (n >= 2) {
            dp[1] = Math.max(dp[0], arr[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int[]{3, 5, -7, 8, 10})); // 15
    }

}
