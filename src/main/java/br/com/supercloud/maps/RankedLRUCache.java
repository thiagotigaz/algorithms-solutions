package br.com.supercloud.maps;

import java.util.*;

public class RankedLRUCache<K, V extends RankedLRUCache.Rankable> {
    private final TreeMap<Long, List<K>> rankedMap = new TreeMap<>((o1, o2) -> {
        if (o1.equals(o2)) {
            return 0;
        }
        return o1 < o2 ? -1 : 1;
    });
    private final Map<K, V> values;
    private final DataSource<K, V> ds;
    private final int capacity;


    /**
     * Constructor with a data source (assumed to be slow) and a cache size
     *
     * @param ds       the persistent layer of the the cache
     * @param capacity the number of entries that the cache can hold
     */
    public RankedLRUCache(DataSource<K, V> ds, int capacity) {
        this.ds = ds;
        this.values = new HashMap<>(capacity);
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
        if (values.containsKey(key)) {
            V value = values.get(key);
            System.out.printf("Getting %s  %s from cache%n", key, value);
            printCacheValues();
            return value;
        }
        V value = ds.get(key);
        System.out.printf("Getting %s  %s from ds%n", key, value);
        if (value != null) {
            addToCache(key, value);
        }
        printCacheValues();
        return value;
    }

    private void addToCache(K key, V value) {
        if (values.size() == this.capacity) {
            Map.Entry<Long, List<K>> entry = rankedMap.firstEntry();
            Long rank = entry.getKey();
            List<K> rankItems = entry.getValue();
            K removalItem = rankItems.remove(0);
            this.values.remove(removalItem);
            if (rankItems.isEmpty()) {
                rankedMap.remove(rank);
            }
        }
        addToRankedMap(key, value);
        values.put(key, value);
    }

    private void addToRankedMap(K key, V newValue) {
        // add to new rank set
        if (rankedMap.containsKey(newValue.getRank())) {
            rankedMap.get(newValue.getRank()).add(key);
        } else {
            List<K> ksNew = new LinkedList<>(Collections.singletonList(key));
            rankedMap.put(newValue.getRank(), ksNew);
        }
    }

    void printCacheValues() {
        values.forEach((key, value) -> System.out.print(key + ":" + value.getRank() + ", "));
        System.out.println();
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

    static class Person implements Rankable {

        private final long rank;

        public Person(long rank) {
            this.rank = rank;
        }

        @Override
        public long getRank() {
            return rank;
        }

        @Override
        public String toString() {
            return "Person { rank: "  + rank + " }";
        }
    }

    public static void main(String[] args) {
        DataSource<String, Person> ds = new DataSource<String, Person>() {
            private final Map<String, Person> map = new HashMap<String, Person>() {{
                put("thiago", new Person(100L));
                put("talita", new Person(50L));
                put("pedro", new Person(30L));
                put("jose", new Person(10L));
                put("joao", new Person(5L));
                put("maria", new Person(60L));
                put("rebeka", new Person(60L));
                put("thelma", new Person(60L));
            }};

            @Override
            public Person get(String key) {
                return map.get(key);
            }
        };
        RankedLRUCache<String, Person> retainBestCache = new RankedLRUCache<>(ds, 3);
        retainBestCache.get("thiago");
        retainBestCache.get("talita");
        retainBestCache.get("talita");
        retainBestCache.get("pedro"); // cache gets full
        retainBestCache.get("joao"); // pedro gets out, joao is inserted
        retainBestCache.get("maria"); // joao gets out, maria is inserted
        retainBestCache.get("talita"); // cache stays the same as talita is already present
        retainBestCache.get("rebeka"); // talita gets out, rebeka is inserted
        retainBestCache.get("thelma"); // maria gets out, thelma is inserted
        retainBestCache.get("maria"); // rebeka gets out, maria is inserted
    }
}
