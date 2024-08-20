package com.company.designpattern.problmes.basic.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

class WailNotifyBlockingQueueDriver {
    public static void sleep(int dur){
        try {
            Thread.sleep(dur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        WailNotifyBlockingQueue<Integer> q = new WailNotifyBlockingQueue<>(2);

        AtomicInteger ele = new AtomicInteger(0);

        Thread producer = new Thread(() -> {
            while(true) {
                try {
                    q.enqueue(ele.getAndIncrement());
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while(true) {
                try {
                    q.dequeue();
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

class WailNotifyBlockingQueue<T> {
    private Queue<T> queue;
    private int size;

    public WailNotifyBlockingQueue(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
    }

    public synchronized void enqueue(T ele) throws InterruptedException {
        while(queue.size()>=size) {
            System.out.println("Waiting to enqueue "+ele+", for "+Thread.currentThread().getName());
            wait();
        }

        queue.add(ele);
        System.out.println("Enqueued "+ele+", for "+Thread.currentThread().getName());
        notify();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.size()<=0) {
            System.out.println("Waiting to dequeue, for "+Thread.currentThread().getName());
            wait();
        }

        T ele = queue.poll();
        notify();

        System.out.println("Dequeued "+ele+", for "+Thread.currentThread().getName());
        return ele;
    }
}
