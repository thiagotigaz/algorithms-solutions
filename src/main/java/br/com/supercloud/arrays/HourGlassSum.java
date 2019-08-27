package br.com.supercloud.arrays;

public class HourGlassSum {

    static int hourglassSum(int[][] arr) {
        int n = arr.length - 2, m = arr[0].length - 2;
        int maxHourGlassSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int fLine = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int sLine = arr[i + 1][j + 1];
                int tLine = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                int sum = fLine + sLine + tLine;
                maxHourGlassSum = Math.max(maxHourGlassSum, sum);
            }
        }

        return maxHourGlassSum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        System.out.println(hourglassSum(arr));
    }


}
