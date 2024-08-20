package com.company.designpattern.problmes.logger;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new LoggerFactory();
        Logger logger = loggerFactory.getLogger("yyyy-mm-dd hh:MM:ss",LogLevel.DEBUG,LoggerType.ASYNC,new ConsoleSink(), 10);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;++i) {
            int finalI = i;
            executorService.submit(()->{
                try {
                    Thread.sleep((Math.abs(new Random().nextInt()))%1000);
                    logger.warn("Message "+ finalI);
                }catch (Exception e) {
                    e.printStackTrace();
                };
            });
        }

    }
}
