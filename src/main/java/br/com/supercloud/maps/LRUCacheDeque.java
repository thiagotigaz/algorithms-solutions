package br.com.supercloud.maps;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheDeque<K, V> {

    private final Deque<K> deque = new LinkedList<>();
    private final Map<K, V> values;
    private final int capacity;

    public LRUCacheDeque(int capacity) {
        this.capacity = capacity;
        values = new HashMap<>(capacity);
    }

    public V get(K key) {
        if (values.containsKey(key)) {
            refreshNewness(key);
        }
        return values.get(key);
    }

    public void put(K key, V value) {
        boolean contains = values.containsKey(key);
        if (contains) {
            refreshNewness(key);
        }
        if (values.size() == capacity) {
            values.remove(deque.remove());
        }
        if (!contains) {
            deque.add(key);
        }

        values.put(key, value);
    }

    private void refreshNewness(K key) {
        deque.remove(key);
        deque.add(key);
    }


    public static void main(String[] args) {
        LRUCacheDeque<String, Integer> lruCache = new LRUCacheDeque<>(3);
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
    }


}
