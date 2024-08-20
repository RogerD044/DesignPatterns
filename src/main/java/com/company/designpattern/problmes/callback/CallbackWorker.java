package com.company.designpattern.problmes.callback;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;

public class CallbackWorker implements Runnable{
    ConcurrentSkipListSet<Task> taskQueue;
    ExecutorService executorService;


    public CallbackWorker(ConcurrentSkipListSet<Task> taskQueue, ExecutorService executorService) {
        this.taskQueue = taskQueue;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        while (true) {
            if(!taskQueue.isEmpty()) {
                Task task = taskQueue.iterator().next();
                if(task.getTimestamp()<System.currentTimeMillis()) {
                    taskQueue.remove(task);
                    new Thread(task.getCallbackTask()).start();
                }
            }
        }
    }
}
