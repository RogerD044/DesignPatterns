package com.company.designpattern.problmes.callback;

import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class CallbackImpl implements Callback{
    private ConcurrentSkipListSet<Task> taskQueue;
    private Timer timer;
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    Thread t;

    public CallbackImpl(int poolSize) {
        this.taskQueue = new ConcurrentSkipListSet<Task>(Comparator.comparingLong(Task::getTimestamp));
        this.t = new Thread(new CallbackWorker(taskQueue,executorService));
        t.start();
//        this.timer = new Timer();
    }

    @Override
    public void execute(long delay, Runnable callback) {
        System.out.println("Adding task" + delay);
        taskQueue.add(new Task(System.currentTimeMillis() + delay,callback));
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                callback.run();
//            }
//        },1000);
    }
}
