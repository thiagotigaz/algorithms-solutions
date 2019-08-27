package br.com.supercloud.arrays;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        if (n < s.length()) {
            return countAs(s, (int) n);
        } else {
            long times = n / s.length();
            return countAs(s, s.length()) * times + countAs(s, (int) (n % s.length()));
        }
    }

    private static int countAs(String s, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long count = repeatedString("a", 1000000000000L);
        System.out.println(count);
    }

}
