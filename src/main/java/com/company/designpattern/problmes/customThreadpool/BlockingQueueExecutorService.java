package com.company.designpattern.problmes.customThreadpool;

import com.company.designpattern.problmes.customThreadpool.exception.ThreadpoolUnavailableException;

import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExecutorService implements ExecutorService{
    private LinkedBlockingQueue<Runnable> queue;
    private int poolSize;
    boolean isShutDown = false;


    public BlockingQueueExecutorService(int poolSize, int queueSize) {
        this.poolSize = poolSize;
        this.queue = new LinkedBlockingQueue<>(queueSize);
        BlockingQueueWorker executor = null;
        for(int i=0;i<poolSize;++i) {
            executor = new BlockingQueueWorker(queue);
            Thread t = new Thread(executor);
            t.start();
        }
    }

    @Override
    public void submit(Runnable task) throws ThreadpoolUnavailableException {
        if(isShutDown)
            throw new ThreadpoolUnavailableException("Shutdown initiated");

        queue.add(task);
    }

    @Override
    public void shutDown() {
        isShutDown = false;
    }
}
