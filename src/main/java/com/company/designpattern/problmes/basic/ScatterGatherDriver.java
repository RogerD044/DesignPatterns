package com.company.designpattern.problmes.basic;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * Assume 3 threads are making a call to some server, and accumulated results are sent back
 * There is a timout of X seconds, so whatever results is gathered withing X seconds, those are returned
 */
public class ScatterGatherDriver {
    public static void sleep(int dur){
        try {
            Thread.sleep(dur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
//            sleep((int) Math.random()*5000);
            sleep(8000);
            System.out.println(Thread.currentThread().getName()+" completed");
            latch.countDown();
        };

        Thread t1 = new Thread(task, "Thread A");
        Thread t2 = new Thread(task, "Thread B");
        Thread t3 = new Thread(task, "Thread C");

        t1.start();
        t2.start();
        t3.start();

        latch.await(4000, TimeUnit.MILLISECONDS);
        System.out.println("All Tasks Completed");
    }
}