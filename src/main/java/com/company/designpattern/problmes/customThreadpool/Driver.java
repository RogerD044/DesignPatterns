package com.company.designpattern.problmes.customThreadpool;

import com.company.designpattern.problmes.customThreadpool.exception.ThreadpoolUnavailableException;

public class Driver {
    public static void main(String[] args) throws ThreadpoolUnavailableException {
        ExecutorService executorService = new MyExecutorService(2,10);

        for(int i=0;i<10;++i) {
            executorService.submit(new MyRunnableTask("Task"+i));
        }

        System.out.println("Before Shutting Down");
        executorService.shutDown();
        System.out.println("After Shutting Down");

        // Will not be executed
        for(int i=0;i<10;++i) {
            executorService.submit(new MyRunnableTask("Task"+i));
        }


    }

}
