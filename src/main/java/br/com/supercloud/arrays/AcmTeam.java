package br.com.supercloud.arrays;

import java.util.Arrays;

public class AcmTeam {

    static int[] acmTeam(String[] topic) {
        int maxTopics = 0;
        int maxTeams = 0;
        for (int i = 0; i < topic.length; i++) {
            for (int j = i; j < topic.length; j++) {
                int pairTopics = getPairTopics(topic[i], topic[j]);
                if (pairTopics > maxTopics) {
                    maxTopics = pairTopics;
                    maxTeams = 1;
                } else if (pairTopics == maxTopics) {
                    maxTeams++;
                }
            }
        }
        return new int[]{maxTopics, maxTeams};
    }

    private static int getPairTopics(String topicsAttendee1, String topicsAttendee2) {
        int topics = 0;
        for (int i = 0; i < topicsAttendee1.length(); i++) {
            if (topicsAttendee1.charAt(i) == '1' || topicsAttendee2.charAt(i) == '1') {
                topics++;
            }
        }
        return topics;
    }

    public static void main(String[] args) {
        int[] ints = acmTeam(new String[]{"10101", "11100", "11010", "00101"});
        Arrays.stream(ints).forEach(System.out::println);
    }
}
