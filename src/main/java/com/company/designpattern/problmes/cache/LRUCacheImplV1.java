package com.company.designpattern.problmes.cache;

import java.util.concurrent.ConcurrentHashMap;

public class LRUCacheImplV1<K,V> implements Cache<K,V>{
    private long capacity;
    private long ttlInSeconds;
    private ConcurrentHashMap<K, LLNode<K,V>> cacheMap;
    private LinkedList<K,V> accessOrder;

    public LRUCacheImplV1(int capacity, int ttlInSeconds) {
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
        LLNode<K,V> node = cacheMap.get(key);
        accessOrder.removeNode(node);
        accessOrder.addAtFirst(node);

        System.out.println("Key found with Value "+node.record.getValue());
        return node.record.getValue();
    }

    private synchronized void evict() {
        LLNode<K,V> node = accessOrder.removeFromLast();
        cacheMap.remove(node.record.getKey());
    }

    @Override
    public synchronized void put(K key, V value) {

        LLNode<K,V> cacheRecordNode;
        // If Key present, overwrite & update Nodes
        if(cacheMap.containsKey(key)) {
            cacheRecordNode = cacheMap.get(key);
            cacheRecordNode.record.setValue(value);
            accessOrder.removeNode(cacheRecordNode);
            accessOrder.addAtFirst(cacheRecordNode);
            return;
        }

        // If capacity full, evict
        if(cacheMap.size()>=capacity) {
            evict();
        }

        CacheRecord<K,V> cacheRecord = new CacheRecord<K,V>(key,value);
        cacheRecordNode = new LLNode<>(cacheRecord);
        cacheMap.put(key,cacheRecordNode);
        accessOrder.addAtFirst(cacheRecordNode);
    }

    public void printCache() {
        if(cacheMap.isEmpty()) {
            System.out.println("No Values");
            return;
        }

        System.out.println("Printing...");
        cacheMap.forEach((k,v) -> System.out.println(k+","+v.record.getValue()));
    }
}
