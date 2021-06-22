package br.com.supercloud.lists;

import java.util.Arrays;
import java.util.List;

public class MaxRectangleArea {

    public static long maxRectangleArea(List<Integer> arr) {
        long maxArea = 0;
        for (int i = 0; i < arr.size(); i++) {
            Integer height = arr.get(i);
            int start = i;
            int end = i;
            for (int j = i; j >= 0; j--) {
                if (arr.get(j) < height) {
                    break;
                }
                start = j;
            }
            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) < height) {
                    break;
                }
                end = j;
            }
            maxArea = Math.max(maxArea, height * (end - start + 1L));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxRectangleArea(Arrays.asList(1, 2, 3, 4, 3, 2))); // 10
        System.out.println(maxRectangleArea(Arrays.asList(1, 3, 4, 3, 3, 4, 2, 4, 5, 6))); // 18
        System.out.println(maxRectangleArea(Arrays.asList(1, 3, 2, 4, 3, 2, 4, 5, 6, 4, 3, 5, 2, 1))); // 24
        System.out.println(maxRectangleArea(Arrays.asList(1, 2, 3, 4, 5))); // 9
        System.out.println(maxRectangleArea(Arrays.asList(8979, 4570, 6436, 5083, 7780, 3269, 5400, 7579, 2324, 2116))); // 26152
    }
}
