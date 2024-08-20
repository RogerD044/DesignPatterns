package problems.cache;

import com.company.designpattern.problmes.cache.CacheProvider;
import com.company.designpattern.problmes.cache.LFUEvictionPolicy;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class LFUCacheTest {

    @Test
    public void test() {
        CacheProvider<Integer,Integer> cacheProvider = new CacheProvider<Integer,Integer>( new LFUEvictionPolicy<Integer,Integer>(),3);
        Assertions.assertNull(cacheProvider.get(1));

        cacheProvider.put(1,1);
        cacheProvider.put(2,2);
        cacheProvider.put(3,3);

//        new Thread(() -> cacheProvider.put(1,1)).start();
//        new Thread(() -> cacheProvider.put(2,2)).start();
//        new Thread(() -> cacheProvider.put(3,3)).start();
//
//        new Thread(() -> cacheProvider.get(1)).start();
//        new Thread(() -> cacheProvider.get(2)).start();
//        new Thread(() -> cacheProvider.get(2)).start();
//        new Thread(() -> cacheProvider.get(3)).start();
//        new Thread(() -> cacheProvider.get(3)).start();
//        new Thread(() -> cacheProvider.get(1)).start();
//        new Thread(() -> cacheProvider.get(1)).start();
//        new Thread(() -> cacheProvider.get(1)).start();

        Assertions.assertEquals(2,cacheProvider.get(2));
        Assertions.assertEquals(2,cacheProvider.get(2));
//
        Assertions.assertEquals(3,cacheProvider.get(3));

        cacheProvider.put(4,4);
//
        Assertions.assertNull(cacheProvider.get(1));
//
        cacheProvider.printCache();
    }
}
