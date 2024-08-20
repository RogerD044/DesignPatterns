package com.company.designpattern.problmes.customThreadpool;

public class Worker implements Runnable {
    private final BlockingQueue blockingQueue;

    public Worker(BlockingQueue queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable task = blockingQueue.dequeue();
                task.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
