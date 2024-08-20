package com.company.designpattern.problmes.cache;

public class LLNode<K,V> {
    public CacheRecord<K,V> record;
    public LLNode<K,V> prev;
    public LLNode<K,V> next;

    public LLNode(CacheRecord record) {
        this.record = record;
        this.next = null;
        this.prev = null;
    }
}
