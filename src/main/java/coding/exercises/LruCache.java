package coding.exercises;

import java.util.Optional;

public interface LruCache<K, V> {

    Optional<V> get(K key);

    void put(K key, V value);
}
