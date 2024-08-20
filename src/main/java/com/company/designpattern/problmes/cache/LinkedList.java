package com.company.designpattern.problmes.cache;

public class LinkedList<K,V> {
    private LLNode<K,V> head;
    private LLNode<K,V> tail;

    public LinkedList() {
        this.head = new LLNode<>(new CacheRecord<K,V>(null,null));
        this.tail = new LLNode<>(new CacheRecord<K,V>(null,null));
        head.next = tail;
        tail.prev = head;
    }

    public synchronized void removeNode(LLNode<K,V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public synchronized void addAtFirst(LLNode<K,V> node) {
        LLNode<K,V> oldHead = head.next;

        node.next = oldHead;
        node.prev = head;

        oldHead.prev = node;

        head.next = node;
    }

    public synchronized LLNode<K,V> removeFromLast() {
        LLNode<K,V> nodeToRemove = tail.prev;

        nodeToRemove.prev.next = tail;
        tail.prev = nodeToRemove.prev;

        return nodeToRemove;
    }
}
