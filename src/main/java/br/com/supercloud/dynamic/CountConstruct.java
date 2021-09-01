package br.com.supercloud.dynamic;

import java.util.*;

public class CountConstruct {
    public static int countConstruct(String targetWord, Set<String> dictionary) {
        if (Objects.equals(targetWord, "")) return 1;
        int totalCount = 0;
        for (int i = 0; i <= targetWord.length(); i++) {
            String preffix = targetWord.substring(0, i);
            if (dictionary.contains(preffix)) {
                totalCount += countConstruct(targetWord.substring(i), dictionary);
            }
        }
        return totalCount;
    }

    private static int countConstructWithMemo(String targetWord, HashSet<String> dictionary, HashMap<String, Integer> memo) {
        if (memo.containsKey(targetWord)) return memo.get(targetWord);
        if (Objects.equals(targetWord, "")) return 1;
        int totalCount = 0;
        for (int i = 0; i <= targetWord.length(); i++) {
            String preffix = targetWord.substring(0, i);
            if (dictionary.contains(preffix)) {
                totalCount += countConstructWithMemo(targetWord.substring(i), dictionary, memo);
            }
        }
        memo.put(targetWord, totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new HashSet<>(Arrays.asList("purp", "p", "ur", "le", "puurpl")))); // 2
        System.out.println(countConstructWithMemo("purple", new HashSet<>(Arrays.asList("purp", "p", "ur", "le", "puurpl")), new HashMap<>())); // 2

        System.out.println(countConstruct("abcdef", new HashSet<>(Arrays.asList("ab", "abc", "cd", "def", "abcd")))); // 1
        System.out.println(countConstructWithMemo("abcdef", new HashSet<>(Arrays.asList("ab", "abc", "cd", "def", "abcd")), new HashMap<>())); // 1

        System.out.println(countConstruct("skateboard", new HashSet<>(Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")))); // 0
        System.out.println(countConstructWithMemo("skateboard", new HashSet<>(Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")), new HashMap<>())); // 0

        System.out.println(countConstruct("enterapotentpot", new HashSet<>(Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")))); // 4
        System.out.println(countConstructWithMemo("enterapotentpot", new HashSet<>(Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")), new HashMap<>())); // 4

        // Next line takes forever without memo
        // System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new HashSet<>(Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))); // 0
        System.out.println(countConstructWithMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new HashSet<>(Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")), new HashMap<>())); // 0
    }
}
