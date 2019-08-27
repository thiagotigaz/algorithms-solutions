package br.com.supercloud.arrays;

public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
        int jumps = -1;
        for (int i = 0; i < c.length; i++, jumps++) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i++;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int jumps = jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0});
        System.out.println(jumps);
    }
}
