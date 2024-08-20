package com.company.designpattern.problmes.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncLogger extends Logger{
    private ExecutorService executorService;

    public AsyncLogger(LogLevel level, Sink sink,String dateFormat, int buffer) {
        super(level,sink,dateFormat);
        this.executorService = Executors.newFixedThreadPool(buffer);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        executorService.submit(() -> {logMessage(logLevel,message);});
    }


}
