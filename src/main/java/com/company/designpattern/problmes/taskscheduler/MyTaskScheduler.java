package com.company.designpattern.problmes.taskscheduler;

import com.company.designpattern.problmes.taskscheduler.schema.ITask;
import com.company.designpattern.problmes.taskscheduler.schema.OnetimeTask;
import com.company.designpattern.problmes.taskscheduler.schema.RepeatableTask;
import com.company.designpattern.problmes.taskscheduler.worker.Worker;

import java.util.Comparator;
import java.util.concurrent.*;

public class MyTaskScheduler implements ITaskScheduler{
    private final PriorityBlockingQueue<ITask> taskQueue;
    private Worker[] workers;
    private boolean isShutDown;

    public MyTaskScheduler(int poolSize) {
        taskQueue = new PriorityBlockingQueue<ITask>(1000, Comparator.comparingLong(ITask::getNextTriggerTime));
        workers = new Worker[poolSize];
        for(int i=0;i<poolSize;i++) {
            workers[i] = new Worker(taskQueue);
            Thread thread = new Thread(workers[i]);
            thread.start();
        }
        this.isShutDown = false;
    }

    @Override
    public void schedule(Runnable task, long triggerAt) {
        if(isShutDown) {
            System.out.println("Cannot server more requests");
            return;
        }

        taskQueue.add(new OnetimeTask(task, triggerAt));
    }

    @Override
    public void scheduleAtFixedInterval(Runnable task, long interval) {
        if(isShutDown) {
            System.out.println("Cannot server more requests");
            return;
        }
        taskQueue.add(new RepeatableTask(task, System.currentTimeMillis(), interval));
    }

    public void shutDown() {
        System.out.println("Shutdown Initiated");
        isShutDown = true;
        for(int i=0;i<workers.length;++i) {
            workers[i].shutDown();
        }
    }
}
