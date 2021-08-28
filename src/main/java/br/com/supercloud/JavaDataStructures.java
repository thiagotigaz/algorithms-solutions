package br.com.supercloud;

import java.util.*;

public class JavaDataStructures {

    public static void lists() {
        // Increases size by 50% when at capacity O(n) insertion and deletion, O(1) access
        List<Integer> arrayList = new ArrayList<>();
        // O(1) insertion and deletion, O(n) search and access
        List<Integer> linkedList = new LinkedList<>();
        // Doubles the size when at capacity O(n) insertion and deletion, O(1) access / methods are synchronized
        List<Integer> vector = new Vector<>();
    }

    public static void sets() {
        // no ordering
        Set<Integer> hashset = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        hashset.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        // order of insertion
        Set<Integer> linkedHashset = new LinkedHashSet<>(Arrays.asList(2, 1, 4, 3, 5, 6, 7, 8));
        linkedHashset.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
        // natural order
        Set<Integer> treeset = new TreeSet<>(Arrays.asList(8, 7, 6, 1, 2, 3, 4, 5));
        treeset.forEach(integer -> System.out.print(integer + " "));
        System.out.println();
    }

    public static void maps() {
        Map<String, Integer> hashmap = new HashMap<String, Integer>() {{
            put("z", 10);
            put("b", 3);
            put("a", 1);
            put("d", 4);
        }};
        hashmap.forEach((s, integer) -> System.out.println("K: " + s + ", V: " + integer));
        System.out.println();
        TreeMap<String, Integer> treemap = new TreeMap<String, Integer>() {{
            put("z", 10);
            put("b", 3);
            put("a", 1);
            put("d", 4);
        }};
        treemap.forEach((s, integer) -> System.out.println("K: " + s + ", V: " + integer));
        System.out.println();
        Map<String, Integer> linkedmap = new LinkedHashMap<String, Integer>(){{
            put("z", 10);
            put("b", 3);
            put("a", 1);
            put("d", 4);
        }};
        linkedmap.forEach((s, integer) -> System.out.println("K: " + s + ", V: " + integer));
        System.out.println();
    }

    public static void main(String[] args) {
        sets();
        maps();
    }
}
