package com.company.designpattern.problmes.cache;

public interface Cache<K,V> {

    V get(K key);
    void put(K key, V value);
    void printCache();
}
