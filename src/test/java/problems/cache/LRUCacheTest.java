package problems.cache;

import com.company.designpattern.problmes.cache.Cache;
import com.company.designpattern.problmes.cache.LRUCacheImplV1;
import com.company.designpattern.problmes.cache.LRUCacheImplV2;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LRUCacheTest {
    @Test
    public void testLRUImpl1() {
        Cache<Integer,Integer> cache = new LRUCacheImplV1<>(3,300);
        Assertions.assertNull(cache.get(1));

        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);

        Assertions.assertEquals(1,cache.get(1));
        Assertions.assertEquals(2,cache.get(2));

        cache.put(4,4);

        Assertions.assertNull(cache.get(3));
    }

    @Test
    public void testLRUImpl2() {
        Cache<Integer,Integer> cache = new LRUCacheImplV2<>(3,300);
        Assertions.assertNull(cache.get(1));

        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);

        Assertions.assertEquals(1,cache.get(1));
        Assertions.assertEquals(2,cache.get(2));

        cache.put(4,4);

        Assertions.assertNull(cache.get(3));
    }
}
