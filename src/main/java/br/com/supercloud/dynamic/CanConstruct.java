package br.com.supercloud.dynamic;

import java.util.*;

public class CanConstruct {

    public static boolean canConstruct(String word, Set<String> dictionary) {
        if (word.equals("")) return true;
        for (int i = 0; i <= word.length(); i++) {
            String substr = word.substring(0, i);
            if (dictionary.contains(substr) && canConstruct(word.substring(i), dictionary)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canConstructWithMemo(String word, Set<String> dictionary, Map<String, Boolean> memo) {
        if (memo.containsKey(word)) return memo.get(word);
        if (word.equals("")) return true;
        for (int i = 0; i <= word.length(); i++) {
            String substr = word.substring(0, i);
            if (dictionary.contains(substr) && canConstructWithMemo(word.substring(i), dictionary, memo)) {
                memo.put(word, true);
                return true;
            }
        }
        return false;
    }

    public static boolean canConstructTabulation(String target, Set<String> dictionary) {
        int m = target.length();
        boolean[] result = new boolean[m + 1];
        result[0] = true;
        for (int i = 0; i <= m; i++) {
            if (result[i]) {
                for (String word : dictionary) {
                    String subStr = i + word.length() <= target.length()
                            ? target.substring(i, i + word.length())
                            : target.substring(i);
                    if (subStr.equals(word)) {
                        result[i + word.length()] = true;
                    }
                }
            }
        }
        return result[m];
    }

    //              abcdef
    //          ab    abc    abcd
    //      cdef      def       ef
    //    cd          ''
    //  ef

    //             skateboard
    //           ska        sk
    //       teboard      ateboard
    //     t                    ate
    //  eboard                   board
    //                        bo      boar
    //                      ard           d
    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new HashSet<>(Arrays.asList("ab", "abc", "cd", "def", "abcd")))); // true
        System.out.println(canConstructWithMemo("abcdef", new HashSet<>(Arrays.asList("ab", "abc", "cd", "def", "abcd")), new HashMap<>())); // true
        System.out.println(canConstructTabulation("abcdef", new HashSet<>(Arrays.asList("ab", "abc", "cd", "def", "abcd")))); // true

        System.out.println(canConstruct("skateboard", new HashSet<>(Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")))); // false
        System.out.println(canConstructWithMemo("skateboard", new HashSet<>(Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")), new HashMap<>())); // false
        System.out.println(canConstructTabulation("skateboard", new HashSet<>(Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")))); // false

        System.out.println(canConstruct("enterapotentpot", new HashSet<>(Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")))); // true
        System.out.println(canConstructWithMemo("enterapotentpot", new HashSet<>(Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")), new HashMap<>())); // true
        System.out.println(canConstructTabulation("enterapotentpot", new HashSet<>(Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")))); // true

        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeef", new HashSet<>(Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))); // false
        System.out.println(canConstructWithMemo("eeeeeeeeeeeeeeeeeeeef", new HashSet<>(Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")), new HashMap<>())); // false
        System.out.println(canConstructTabulation("eeeeeeeeeeeeeeeeeeeef", new HashSet<>(Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")))); // false
    }
}
