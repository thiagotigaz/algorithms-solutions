package br.com.supercloud.dynamic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllConstruct {

    /*public static List<LinkedList<String>> allConstruct(String targetWord, Set<String> dictionary) {
        if (targetWord.equals(""))
            return new ArrayList<LinkedList<String>>() {{
                add(new LinkedList<>());
            }};
        List<LinkedList<String>> result = new ArrayList<>();
        for (String word : dictionary) {
            if (targetWord.startsWith(word)) {
                String suffix = targetWord.substring(word.length());
                List<LinkedList<String>> suffixWays = allConstruct(suffix, dictionary);
                suffixWays.forEach(way -> way.addFirst(word));
                result.addAll(suffixWays);
            }
        }
        return result;
    }*/

    public static List<LinkedList<String>> allConstructWithMemo(String targetWord, Set<String> dictionary, Map<String, List<LinkedList<String>>> memo) {
        if (memo.containsKey(targetWord)) return memo.get(targetWord);
        if (targetWord.equals("")) return new ArrayList<LinkedList<String>>() {{
            add(new LinkedList<>());
        }};
        List<LinkedList<String>> result = new ArrayList<>();
        for (String word : dictionary) {
            if (targetWord.startsWith(word)) {
                String suffix = targetWord.substring(word.length());
                List<LinkedList<String>> suffixWays = allConstructWithMemo(suffix, dictionary, memo);
                List<LinkedList<String>> newCombinations = suffixWays.stream().map(way -> {
                    LinkedList<String> strings = new LinkedList<>(way);
                    strings.addFirst(word);
                    return strings;
                }).collect(Collectors.toList());
                result.addAll(newCombinations);
            }
        }
        memo.put(targetWord, result);
        return result;
    }

    public static List<List<String>> allConstructTabulation(String targetWord, Set<String> dictionary) {
        int m = targetWord.length();
        List<List<List<String>>> result = new ArrayList<>(m + 1);
        for (int i = 0; i <= m; i++) {
            result.add(new ArrayList<>());
        }
        result.get(0).add(new ArrayList<>());
        for (int i = 0; i <= m; i++) {
            for (String word : dictionary) {
                String subStr = i + word.length() <= m
                        ? targetWord.substring(i, i + word.length())
                        : targetWord.substring(i);
                if (subStr.equals(word)) {
                    List<List<String>> newCombinations = result.get(i).stream().map(combination -> {
                        List<String> strings = new ArrayList<>(combination);
                        strings.add(word);
                        return strings;
                    }).collect(Collectors.toList());
                    result.get(i + word.length()).addAll(newCombinations);
                }
            }
        }

        return result.get(m);
    }

    public static void main(String[] args) {
        System.out.println(allConstructWithMemo(
                "purple",
                Stream.of("purp", "p", "ur", "le", "purpl").collect(Collectors.toCollection(HashSet::new)),
                new HashMap<>()
        ));
        System.out.println(allConstructTabulation(
                "purple",
                Stream.of("purp", "p", "ur", "le", "purpl").collect(Collectors.toCollection(HashSet::new))
        ));

//        System.out.println(allConstructWithMemo(
//                "aaaaaaaaaaaaaaaaaaaaaaaa",
//                Stream.of("a", "aa", "aaa", "aaaa", "aaaaa").collect(Collectors.toCollection(HashSet::new)),
//                new HashMap<>()
//        ));
    }
}
