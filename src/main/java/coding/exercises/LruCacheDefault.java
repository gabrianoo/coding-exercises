package coding.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LruCacheDefault<K, V> implements LruCache<K, V> {

    private final int capacity;
    private final Map<K, V> cache;
    private final Map<K, Integer> frequency;

    public LruCacheDefault(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        frequency = new HashMap<>(capacity);
    }

    public Optional<V> get(K key) {
        Optional<V> optionalV = Optional.ofNullable(cache.get(key));
        optionalV.ifPresent(v -> frequency.computeIfPresent(key, (k, integer) -> ++integer));
        return optionalV;
    }

    public void put(K key, V value) {
        if (cache.size() >= capacity) {
            frequency.entrySet().stream()
                    .min(Map.Entry.comparingByValue())
                    .ifPresent(entry -> {
                        cache.remove(entry.getKey());
                        frequency.remove(entry.getKey());
                    });

        }
        cache.put(key, value);
        frequency.putIfAbsent(key, 0);
    }
}
