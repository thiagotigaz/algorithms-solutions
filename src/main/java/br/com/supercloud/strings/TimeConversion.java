package br.com.supercloud.strings;

public class TimeConversion {

    // https://www.hackerrank.com/challenges/time-conversion/problem

    static String timeConversion(String s) {
        int hours = Integer.parseInt(s.substring(0, 2));
        int minutes = Integer.parseInt(s.substring(3, 5));
        int seconds = Integer.parseInt(s.substring(6, 8));
        boolean am = s.endsWith("AM");
        if (am) {
            return String.format("%02d:%02d:%02d", hours == 12 ? 0 : hours, minutes, seconds);
        } else {
            return String.format("%02d:%02d:%02d", hours == 12 ? hours : hours + 12, minutes, seconds);
        }
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:29:30AM")); // 00:29:30
        System.out.println(timeConversion("01:30:31AM")); // 01:30:31
        System.out.println(timeConversion("12:31:32PM")); // 12:31:32
        System.out.println(timeConversion("01:32:33PM")); // 13:32:33
    }
}
