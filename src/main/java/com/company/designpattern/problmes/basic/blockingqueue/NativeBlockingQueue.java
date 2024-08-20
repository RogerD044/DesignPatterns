package com.company.designpattern.problmes.basic.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Implementing using Blocking Queue (Library Funciton)
 */
class NativeBlockingQueue {
    public static void main(String args []) {
        BlockingQueue<Integer> q =  new ArrayBlockingQueue<>(5);

        AtomicInteger ele = new AtomicInteger();

        Thread producer = new Thread(() -> {
            while(true) {
                q.add(ele.getAndIncrement());
            }
        });

        Thread consumer = new Thread(() -> {
            while(true) {
                try {
                    Integer popped = q.take();
                    System.out.println("Removed : "+popped);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        producer.start();
        consumer.start();
    }
}