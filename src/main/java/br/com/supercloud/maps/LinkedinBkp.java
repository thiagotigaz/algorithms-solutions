package br.com.supercloud.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class LinkedinBkp {

    public static class RetainBestCache<K, V extends Rankable> {

        // Add any fields you need here
        private final Map<K, V> cache = new HashMap<>();
        private final Stack<KvPair<K, V>> stack = new Stack<>();

        static class KvPair<K, V> {
            final K key;
            final V value;

            public KvPair(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private final DataSource<K, V> ds;
        private final int capacity;


        /**
         * Constructor with a data source (assumed to be slow) and a cache size
         *
         * @param ds       the persistent layer of the the cache
         * @param capacity the number of entries that the cache can hold
         */
        public RetainBestCache(DataSource<K, V> ds, int capacity) {
            this.ds = ds;
            this.capacity = capacity;
        }

        /**
         * Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
         * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
         * evicting the V with lowest rank among the ones that it has available
         * If there is a tie, the cache may choose any V with lowest rank to evict.
         *
         * @param key the key of the cache entry being queried
         * @return the Rankable value of the cache entry
         */
        public V get(K key) {
            V value = cache.get(key);
            if (value == null) {
                value = ds.get(key);
                addToCache(key, value);
            }
            System.out.println("Cache size: " + cache.size());
            System.out.println("Stack size: " + stack.size());
            System.out.println("Cache Values: " + cache.values().stream()
                    .map(v -> String.valueOf(v.getRank()))
                    .collect(Collectors.joining(",")));
            System.out.println("Stack Values: " + stack.stream()
                    .map(v -> String.valueOf(v.value.getRank()))
                    .collect(Collectors.joining(",")));
            return value;
        }

        private void addToCache(K key, V value) {
            if (cache.size() == this.capacity) {
                cache.remove(stack.pop().key);
            }

            cache.put(key, value);
            KvPair<K, V> kvPair = new KvPair<>(key, value);
            if (stack.isEmpty() || value.getRank() < stack.peek().value.getRank()) {
                stack.push(kvPair);
            } else {
                Stack<KvPair<K, V>> aux = new Stack<>();
                while (!stack.isEmpty() && stack.peek().value.getRank() <= value.getRank()){
                    aux.push(stack.pop());
                }
                aux.push(kvPair);
                while(!aux.isEmpty()) {
                    stack.push(aux.pop());
                }
            }
        }
    }

    /*
     * For reference, here are the Rankable and DataSource interfaces.
     * You do not need to implement them, and should not make assumptions
     * about their implementations.
     */

    public interface Rankable {
        /**
         * Returns the Rank of this object, using some algorithm and potentially
         * the internal state of the Rankable.
         */
        long getRank();
    }

    public interface DataSource<K, V extends Rankable> {
        V get(K key);
    }

    static class Post implements Rankable {

        private final long rank;

        public Post(long rank) {
            this.rank = rank;
        }

        @Override
        public long getRank() {
            return rank;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "rank=" + rank +
                    '}';
        }
    }

    public static void main(String[] args) {
        DataSource<String, Post> ds = new DataSource<String, Post>() {
            private Map<String, Post> map = new HashMap<String, Post>() {{
                put("100", new Post(100L));
                put("3", new Post(3L));
                put("2", new Post(2L));
                put("5", new Post(5L));
                put("10", new Post(10L));
                put("20", new Post(20L));
            }};

            @Override
            public Post get(String key) {
                return map.get(key);
            }
        };
        RetainBestCache<String, Post> retainBestCache = new RetainBestCache<>(ds, 3);
        System.out.println(retainBestCache.get("10"));
        System.out.println(retainBestCache.get("2"));
        System.out.println(retainBestCache.get("3"));
        System.out.println(retainBestCache.get("20"));
        System.out.println(retainBestCache.get("20"));
        System.out.println(retainBestCache.get("5"));
        System.out.println(retainBestCache.get("5"));
        System.out.println(retainBestCache.get("5"));
        System.out.println(retainBestCache.get("100"));
        System.out.println(retainBestCache.get("100"));
        System.out.println(retainBestCache.get("2"));
        System.out.println(retainBestCache.get("20"));
        System.out.println(retainBestCache.get("3"));
    }
}
