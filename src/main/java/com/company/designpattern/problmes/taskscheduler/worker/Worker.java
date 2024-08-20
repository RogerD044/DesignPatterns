package com.company.designpattern.problmes.taskscheduler.worker;

import com.company.designpattern.problmes.callback.Task;
import com.company.designpattern.problmes.taskscheduler.schema.ITask;
import com.company.designpattern.problmes.taskscheduler.schema.RepeatableTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Worker implements Runnable{
    private PriorityBlockingQueue<ITask> taskQueue;
    private boolean isShutDown;

    public Worker(PriorityBlockingQueue<ITask> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                if(!taskQueue.isEmpty()) {
                    ITask task = taskQueue.take();
                    if(task.getNextTriggerTime() < System.currentTimeMillis()) {
                        // Run Task
                         task.execute();
//                        try {
//                            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(task.getRunnableTask());
//                            completableFuture.get(1, TimeUnit.SECONDS);
//                        } catch (TimeoutException e) {
//                            e.printStackTrace();
//                        }

                        // Reschedule
                        if(!isShutDown && task.isRepeatable()) {
                            taskQueue.add(new RepeatableTask(task.getRunnableTask()
                                    ,((RepeatableTask) task).getInterval() + System.currentTimeMillis()
                                    ,((RepeatableTask) task).getInterval()));
                        }

                    } else {
                        taskQueue.add(task);
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        System.out.println("Shutting down "+Thread.currentThread().getName());
        isShutDown = true;
        Thread.currentThread().interrupt();
    }
}
