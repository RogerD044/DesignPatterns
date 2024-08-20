package com.company.designpattern.problmes.cache;

public class CacheDriver {
    public static void main(String[] args) {
        Cache<Integer,Integer> cache = new LRUCacheImplV2<>(3,300);
        cache.get(1);
        cache.printCache();

        cache.put(1,1);
        cache.printCache();

        cache.put(2,2);
        cache.printCache();

        cache.put(3,3);
        cache.printCache();

        cache.get(1);
        cache.get(2);
        cache.printCache();

        cache.put(4,4);
        cache.printCache();

        cache.get(3);
        cache.printCache();

    }
}
