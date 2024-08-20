package com.company.designpattern.problmes.customThreadpool;

import java.util.Random;

public class MyRunnableTask implements Runnable{
    private String taskName;

    public MyRunnableTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Executing Task-"+taskName+" by "+Thread.currentThread().getName());
        try {
            long timeout = (Math.abs(new Random().nextInt()))%1000;
            Thread.sleep(timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
