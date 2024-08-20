package com.company.designpattern.problmes.cache;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class LFUEvictionPolicy<K,V> implements EvictionPolicy<K,V> {
    private ConcurrentHashMap<Long, LinkedList<CacheRecord<K,V>>> accessOrder;
    private long minFreq;

    public LFUEvictionPolicy() {
        this.accessOrder = new ConcurrentHashMap<>();
        this.minFreq = 99999;
    }

    @Override
    public synchronized void keyAccessed(CacheRecord<K,V> record) {
        // Old Record
        if(record.getFrequency()>0) {
            long currFreq = record.getFrequency();
            accessOrder.get(currFreq).remove(record);

            if(accessOrder.get(currFreq).isEmpty()) {
                accessOrder.remove(currFreq);
                if(minFreq==currFreq)
                    minFreq++;
            }
        }

        // New Node to be inserted
        if(record.getFrequency()==0)
            minFreq = 1;

        record.setFrequency(record.getFrequency()+1);
        if(!accessOrder.containsKey(record.getFrequency()))
            accessOrder.put(record.getFrequency(), new LinkedList<>());

        accessOrder.get(record.getFrequency()).addFirst(record);
    }

    @Override
    public synchronized CacheRecord<K,V> evict() {
        CacheRecord<K,V> record = accessOrder.get(minFreq).removeLast();
        if(accessOrder.get(minFreq).isEmpty())
            accessOrder.remove(minFreq);

        minFreq = 1;
        return record;
    }
}
