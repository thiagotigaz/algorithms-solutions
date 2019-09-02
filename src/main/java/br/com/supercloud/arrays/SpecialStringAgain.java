package br.com.supercloud.arrays;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SpecialStringAgain {

    // https://www.hackerrank.com/challenges/special-palindrome-again/problem

    static long substrCount(int n, String s) {
        int count = 0;
        int streakCount = 0;
        char last = 0;
        for (int i = 0; i < n; i++) {
            // We start increasing count for each letter
            streakCount++;
            if (i > 0 && s.charAt(i) != last) {
                // If this is not the first char in the string and the current char is not equals to the last char,
                // we need to start checking for sequences like xx.xx xxx.xxx xxxx.xxxx
                // To do that we know that the right side can't be bigger than the left side, so we use the current
                // streakCount we have already filled with the left side
                int j = 1;
                while (i - j >= 0 && i + j < n && j <= streakCount) {
                    // Make sure the chars to the left and to the right is equal to the last found char
                    if (s.charAt(i - j) == last && s.charAt(i + j) == last) {
                        // if true, increase count and move one step further until the sequence is broken
                        count++;
                        j++;
                    } else {
                        // Break the loop is the xx.xx pattern is not found anymore
                        break;
                    }
                }
                // If current char is different than last we reset to one so that just one is added to the count
                streakCount = 1;
            }
            count += streakCount;
            last = s.charAt(i);
        }
        return count;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(substrCount(5, "asasd")); // 7
        System.out.println(substrCount(7, "abcbaba")); // 10
        System.out.println(substrCount(4, "aaaa")); // 10
        System.out.println(substrCount(3, "aaa")); // 6
        System.out.println(substrCount(3, "aba")); // 4
        // 1272919
        System.out.println(substrCount(727310, fileToString("br/com/supercloud/arrays/specialstringagain.txt")));
    }

    private static String fileToString(String file) throws URISyntaxException, IOException {
        URL resource = SpecialStringAgain.class.getClassLoader().getResource(file);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(bytes);
    }

}
