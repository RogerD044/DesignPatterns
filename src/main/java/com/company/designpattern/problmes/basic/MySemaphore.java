package com.company.designpattern.problmes.basic;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

class MainSemaphore {
    public static void sleep(int dur){
        try {
            Thread.sleep(dur);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MySemaphore semaphore = new MySemaphore(1);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> semaphore.acquire());
        executorService.submit(() -> semaphore.acquire());
        executorService.submit(() -> semaphore.acquire());
        executorService.submit(() -> semaphore.release());
        sleep(1000);
        executorService.submit(() -> semaphore.release());
        sleep(1000);
        executorService.submit(() -> semaphore.release());

        executorService.shutdown();

    }
}

class MySemaphore {
    private AtomicInteger permits;

    public MySemaphore(int permits) {
        if (permits < 0) {
            throw new IllegalArgumentException("Number of permits cannot be negative");
        }
        this.permits = new AtomicInteger(permits);
    }

    public synchronized void acquire() {
        try {
            // Current Thread waits until some thread releases (notify()), so that permit becomes > 0
            while (permits.get() == 0) {
                System.out.println("Waiting by " + Thread.currentThread().getName() + ", Curr Permit " + permits.get());
                wait();
            }
            int currPermit = permits.decrementAndGet();
            System.out.println("Acquired by " + Thread.currentThread().getName() + ", Curr Permit " + currPermit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void release() {
        int currPermit = permits.incrementAndGet();
        System.out.println("Released by "+ Thread.currentThread().getName() +", Curr Permit " + currPermit);

        // On release, permit definitely becomes > 0, so any thread waiting for (permits.get()==0), can continue
        notifyAll();
    }
}
