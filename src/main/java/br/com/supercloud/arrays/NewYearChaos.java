package br.com.supercloud.arrays;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            // Considering each person in the queue has a number equal to i instead of a random number, we can strictly
            // compare q[i] with i-2 so that we now if q[i] has been switched more than two places.
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            // Here we check q[i] with its two left brothers to see if its bigger, if it is we just increase the number
            // of bribe
            for (int j = Math.max(0, i - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }

    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4});
        minimumBribes(new int[]{2, 5, 1, 3, 4});
    }

}
