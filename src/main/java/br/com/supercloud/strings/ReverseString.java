package br.com.supercloud.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {

    private static String reverseString(String s) {
        return reverse(s.toCharArray(), s.length() - 1);
    }

    private static String reverse(char[] charArr, int n) {
        if (n == 0) {
            return String.valueOf(charArr[n]);
        }
        return charArr[n] + reverse(charArr, n - 1);
    }


    // List of Candidate(dpt_id, name, email)
    static class Candidate {


        String name;
        String email;
        Integer dptId;

        public Candidate(String name, String email, Integer dptId) {
            this.name = name;
            this.email = email;
            this.dptId = dptId;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public Integer getDptId() {
            return dptId;
        }

        @Override
        public String toString() {
            return "Candidate{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", dptId=" + dptId +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcd")); // dcba
        System.out.println(reverseString("thiago")); // ogaiht
        List<Candidate> candidates = Arrays.asList(
                new Candidate("Thiago", "thiago@asd.com", 1),
                new Candidate("John", "john@asd.com", 2),
                new Candidate("Tim", "tim@asd.com", 2),
                new Candidate("Talita", "talita@asd.com", 3)
        );

        List<String> filteredCandidates = candidates.stream()
                .filter(c -> c.getDptId() == 1)
                .map(Candidate::getEmail)
                .collect(Collectors.toList());

        filteredCandidates.forEach(System.out::println);
    }
}
