package com.company.designpattern.problmes.cache;

public interface EvictionPolicy<K,V> {
    void keyAccessed(CacheRecord<K,V> record);
    CacheRecord<K,V> evict();
}
