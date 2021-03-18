package coding.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LruCacheDefaultTest {

    private LruCache<Integer, String> lruCache;

    @BeforeEach
    void setup() {
        lruCache = new LruCacheDefault<>(2);
    }

    @Test
    void failIfItemInCacheWasNotFound() {
        lruCache.put(1, "One");

        assertThat(lruCache.get(1)).isNotEmpty().contains("One");
    }

    @Test
    void failIfItemInCacheWasNotEvicted() {
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        assertThat(lruCache.get(1)).isEmpty();
    }

    @Test
    void failIfCapacityIsNotConsidered() {
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.put(3, "Three");

        assertThat(lruCache.get(2)).isNotEmpty().contains("Two");
    }

    @Test
    void failIfLeastRecentlyUsedItemIsNotEvicted() {
        lruCache.put(1, "One");
        lruCache.put(2, "Two");
        lruCache.get(1);
        lruCache.put(3, "Three");

        assertThat(lruCache.get(2)).isEmpty();
    }
}