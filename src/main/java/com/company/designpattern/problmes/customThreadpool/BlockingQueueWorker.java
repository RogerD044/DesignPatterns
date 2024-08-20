package com.company.designpattern.problmes.customThreadpool;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueWorker implements Runnable {
    private LinkedBlockingQueue<Runnable> blockingQueue;

    public BlockingQueueWorker(LinkedBlockingQueue<Runnable> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Runnable task = blockingQueue.take();
                task.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
