package com.company.designpattern.problmes.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.LinkedList;

public class LRUCacheImplV2<K,V> implements Cache<K,V>{
    private long capacity;
    private long ttlInSeconds;
    private ConcurrentHashMap<K, CacheRecord<K,V>> cacheMap;
    private LinkedList<CacheRecord<K,V>> accessOrder;


    public LRUCacheImplV2(int capacity, int ttlInSeconds) {
        this.capacity = capacity;
        this.ttlInSeconds = ttlInSeconds;
        this.cacheMap = new ConcurrentHashMap<>();
        this.accessOrder = new LinkedList<>();
    }

    @Override
    public synchronized V get(K key) {
        // If not present, return
        if(!cacheMap.containsKey(key)) {
            System.out.println("Key not found");
            return null;
        }

        // If present, update cache & return
        CacheRecord<K,V> record = cacheMap.get(key);
        accessOrder.remove(record);
        accessOrder.addFirst(record);

        System.out.println("Key found with Value "+record.getValue());
        return record.getValue();
    }

    private synchronized void evict() {
        CacheRecord<K,V> record = accessOrder.removeLast();
        cacheMap.remove(record.getKey());
    }

    @Override
    public synchronized void put(K key, V value) {

        CacheRecord<K,V> cacheRecord;
        // If Key present, overwrite & update Nodes
        if(cacheMap.containsKey(key)) {
            cacheRecord = cacheMap.get(key);
            cacheRecord.setValue(value);
            accessOrder.remove(cacheRecord);
            accessOrder.addFirst(cacheRecord);
            return;
        }

        // If capacity full, evict
        if(cacheMap.size()>=capacity) {
            evict();
        }

        cacheRecord = new CacheRecord<K,V>(key,value);
        cacheMap.put(key,cacheRecord);
        accessOrder.addFirst(cacheRecord);
    }

    public void printCache() {
        if(cacheMap.isEmpty()) {
            System.out.println("No Values");
            return;
        }

        System.out.println("Printing...");
        cacheMap.forEach((k,v) -> System.out.println(k+","+v.getValue()));
    }
}
