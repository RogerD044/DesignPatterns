package com.company.designpattern.problmes.taskscheduler;

import com.company.designpattern.problmes.taskscheduler.schema.ITask;

import java.util.Date;
import java.util.Random;

public class TaskSchedulerDriver {
    public static void main(String[] args) {
        Runnable onetimeTask = () -> {System.out.println(new Date()+" | Onetime task executed by "+Thread.currentThread().getName());};
        Runnable repeatableTask = () -> {System.out.println(new Date()+" | Repeatable task executed by "+Thread.currentThread().getName());};

        ITaskScheduler taskScheduler = new MyTaskScheduler(10);

        for(int i=0;i<10;++i) {
            int finalI = i;
            taskScheduler.schedule(() -> {System.out.println(new Date()+" | Onetime task "+ finalI +" executed by "+Thread.currentThread().getName());}, System.currentTimeMillis() + ((new Random()).nextInt()%5000));
//            taskScheduler.scheduleAtFixedInterval(() -> {System.out.println(new Date()+" | Repeatable task "+ finalI +" executed by "+Thread.currentThread().getName());}, 1000);
        }

        try{ Thread.sleep(10000);} catch (Exception e) {}
        taskScheduler.shutDown();

        for(int i=0;i<10;++i) {
            int finalI = i;
            taskScheduler.schedule(() -> {System.out.println(new Date()+" | Onetime task "+ finalI +" executed by "+Thread.currentThread().getName());}, System.currentTimeMillis() + ((new Random()).nextInt()%5000));
            taskScheduler.scheduleAtFixedInterval(() -> {System.out.println(new Date()+" | Repeatable task "+ finalI +" executed by "+Thread.currentThread().getName());}, 1000);
        }
    }
}
