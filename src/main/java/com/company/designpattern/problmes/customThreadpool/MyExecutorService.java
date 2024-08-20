package com.company.designpattern.problmes.customThreadpool;

import com.company.designpattern.problmes.customThreadpool.exception.QueueFullException;
import com.company.designpattern.problmes.customThreadpool.exception.ThreadpoolUnavailableException;

public class MyExecutorService implements ExecutorService{
    private BlockingQueue queue;
    private int poolSize;
    boolean isShutDown = false;
    Thread[] threads;


    public MyExecutorService(int poolSize, int queueSize) {
        this.poolSize = poolSize;
        this.queue = new BlockingQueue(queueSize);
        this.threads = new Thread[poolSize];
        for(int i=0;i<poolSize;++i) {
            Worker worker = new Worker(queue);
            Thread t = new Thread(worker);
            threads[i] = t;
            t.start();
        }
    }

    @Override
    public void submit(Runnable task) throws ThreadpoolUnavailableException {
        if(isShutDown)
            throw new ThreadpoolUnavailableException("Shutdown initiated");

        try {
            queue.enqueue(task);
        } catch (InterruptedException | QueueFullException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutDown() {
        isShutDown = true;
//        for(int i=0;i<poolSize;++i) {
//            try {
//                threads[i].interrupt();
//                threads[i].join();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
