package br.com.supercloud.dynamic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DictionaryWords {

    static Set<String> dictionary = new HashSet<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile"));

    public static boolean isWordBreakable(String word) {
        int size = word.length();
        if (size == 0) return true;
        for (int i = 1; i <= size; i++) {
            String current = word.substring(0, i);
            String rest = word.substring(i, size);
            if (dictionary.contains(current) && isWordBreakable(rest)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isWordBreakable("i"));
        System.out.println(isWordBreakable("iii"));
        System.out.println(isWordBreakable("ilike"));
        System.out.println(isWordBreakable("ilikesamsung"));
        System.out.println(isWordBreakable("imobile"));
    }

}
