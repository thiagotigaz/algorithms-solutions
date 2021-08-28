package br.com.supercloud.maps;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheHashMap<K, V> {

    static class CacheEntry<K, V> {
        K key;
        V value;
        CacheEntry<K, V> left;
        CacheEntry<K, V> right;

        public CacheEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private CacheEntry<K, V> start, end;
    private final Map<K, CacheEntry<K, V>> values;
    private final int capacity;

    public LRUCacheHashMap(int capacity) {
        this.capacity = capacity;
        values = new HashMap<>(capacity);
    }

    public V get(K key) {
        if (values.containsKey(key)) {
            CacheEntry<K, V> entry = values.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return null;
    }

    private void removeNode(CacheEntry<K, V> entry) {
        if (entry.left != null) {
            entry.left.right = entry.right;
        } else {
            start = entry.right;
        }

        if (entry.right != null) {
            entry.right.left = entry.left;
        } else {
            end = entry.left;
        }
    }

    private void addAtTop(CacheEntry<K, V> entry) {
        entry.right = start;
        entry.left = null;
        if (start != null) {
            start.left = entry;
        }
        start = entry;
        if (end == null) {
            end = start;
        }
    }

    public void put(K key, V value) {
        if (values.containsKey(key)) {
            CacheEntry<K, V> entry = values.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        } else {
            CacheEntry<K, V> entry = new CacheEntry<>(key, value);
            if (values.size() == capacity) {
                values.remove(end.key);
                removeNode(end);
                addAtTop(entry);
            } else {
                addAtTop(entry);
            }

            values.put(key, entry);
        }
    }

    public static void main(String[] args) {
        LRUCacheHashMap<String, Integer> lruCache = new LRUCacheHashMap<>(3);
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
