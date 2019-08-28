package br.com.supercloud.maps;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // https://www.hackerrank.com/challenges/ctci-ransom-note/

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : magazine) {
            if (wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            } else {
                wordFrequency.put(word, 1);
            }
        }

        for (String word : note) {
            if (!wordFrequency.containsKey(word) || wordFrequency.get(word) == 0) {
                System.out.println("No");
                return;
            } else {
                wordFrequency.put(word, wordFrequency.get(word) - 1);
            }
        }
        System.out.println("Yes");
    }

}
