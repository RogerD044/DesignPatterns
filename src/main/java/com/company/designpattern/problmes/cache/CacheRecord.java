package com.company.designpattern.problmes.cache;

public class CacheRecord<K,V> {
    private K key;
    private V value;
    private long frequency;
    private long createdAtTimestampInMillis;

    public CacheRecord(K key, V value) {
        this.key = key;
        this.value = value;
        this.frequency = 0;
        this.createdAtTimestampInMillis = System.currentTimeMillis();
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public long getCreatedAtTimestampInMillis() {
        return createdAtTimestampInMillis;
    }

    public void setCreatedAtTimestampInMillis(long createdAtTimestampInMillis) {
        this.createdAtTimestampInMillis = createdAtTimestampInMillis;
    }

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }
}
