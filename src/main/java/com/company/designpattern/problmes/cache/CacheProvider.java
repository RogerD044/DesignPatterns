package com.company.designpattern.problmes.cache;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CacheProvider<K,V> implements Cache<K,V>{

    private ConcurrentHashMap<K, CacheRecord<K,V>> cacheMap;
    private EvictionPolicy<K,V> evictionPolicy;
    private int capacity;

    public CacheProvider(EvictionPolicy<K,V> evictionPolicy, int capacity) {
        this.cacheMap = new ConcurrentHashMap<>();
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public V get(K key) {
        CacheRecord<K,V> cacheRecord = cacheMap.getOrDefault(key,null);

        if(Objects.isNull(cacheRecord))
            return null;

        evictionPolicy.keyAccessed(cacheRecord);

        return cacheRecord.getValue();
    }

    @Override
    public void put(K key, V value) {
        if(!cacheMap.containsKey(key) && cacheMap.size()>=capacity) {
            CacheRecord<K,V> toEvict = evictionPolicy.evict();
            cacheMap.remove(toEvict.getKey());
        }

        CacheRecord<K,V> cacheRecord;
        if(cacheMap.containsKey(key)) {
            cacheRecord = cacheMap.get(key);
            cacheRecord.setValue(value);
        } else {
            cacheRecord = new CacheRecord<>(key, value);
        }

        cacheMap.put(key,cacheRecord);
        evictionPolicy.keyAccessed(cacheRecord);
    }

    @Override
    public void printCache() {
        cacheMap.forEach((k,v) -> System.out.println(k));
    }
}
