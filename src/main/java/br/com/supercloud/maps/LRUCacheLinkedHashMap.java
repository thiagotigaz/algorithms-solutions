package br.com.supercloud.maps;

import java.util.*;

public class LRUCacheLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int capacity;

    public LRUCacheLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMap<String, Integer> lruCache = new LRUCacheLinkedHashMap<>(3);
        lruCache.put("a", 1);
        lruCache.put("b", 2);
        lruCache.put("c", 3);
        lruCache.put("d", 4);
        System.out.println(lruCache.get("a"));
        System.out.println(lruCache.get("b"));
        System.out.println(lruCache.get("c"));
        System.out.println(lruCache.get("d"));
        System.out.println(lruCache.get("b"));
        lruCache.put("e", 5);
        System.out.println(lruCache.get("c"));
        System.out.println(lruCache.get("a"));
    }


}
