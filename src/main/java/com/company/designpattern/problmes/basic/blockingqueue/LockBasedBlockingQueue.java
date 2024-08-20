package com.company.designpattern.problmes.basic.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Blocking Queue with Locks and conditions
 */

class LockBasedBlockingQueueDriver {
    public static void sleep(int dur){
        try {
            Thread.sleep(dur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args []) {
        LockBasedBlockingQueue q =  new LockBasedBlockingQueue(5);

        AtomicInteger ele = new AtomicInteger();

        Thread producer = new Thread(() -> {
            while(true) {
                q.enqueue(ele.getAndIncrement());
                sleep(800);
            }});

        Thread consumer = new Thread(() -> {
            while(true) {
                int popped = q.dequeue();
                sleep(1000);
            }});

        producer.start();
        consumer.start();
    }
}

class LockBasedBlockingQueue {
    private Queue<Integer> q;
    private int capacity;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public LockBasedBlockingQueue(int size) {
        this.q = new LinkedList<>();
        this.capacity = size;
    }

    public void enqueue(int ele) {
        lock.lock();
        try {
            while(q.size()>=capacity) {
                System.out.println("Queue Full. Waiting !!!");
                notFull.await();
            }

            q.add(ele);
            System.out.println("Inserted element. Size:"+q.size());
            notEmpty.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int dequeue() {
        lock.lock();
        try {
            while (q.size()<=0) {
                System.out.println("Queue Empty. Waiting !!!");
                notEmpty.await();
            }

            int ele = q.poll();
            System.out.println("Removed element. Size:"+q.size());
            notFull.signal();

            return ele;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return -1;
    }
}