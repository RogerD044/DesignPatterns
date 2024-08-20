package com.company.designpattern.problmes.customThreadpool;

import com.company.designpattern.problmes.customThreadpool.exception.QueueFullException;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Runnable> queue;
    private int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public synchronized void enqueue(Runnable task) throws InterruptedException, QueueFullException {
        while(queue.size()>=capacity) {
            System.out.println("Queue full, waiting for dequeue operation : "+Thread.currentThread().getName());
            wait();
        }

        queue.offer(task);
        notifyAll();
    }

    public synchronized Runnable dequeue() throws InterruptedException {
        while(queue.isEmpty()) {
            System.out.println("Queue Empty, waiting for enqueue operation : "+Thread.currentThread().getName());
            wait();
        }

        Runnable runnable = queue.poll();
        notifyAll();
        return runnable;
    }
}
