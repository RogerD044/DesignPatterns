package com.company.designpattern.problmes.logger;

public class ConsoleSink implements Sink{

    @Override
    public synchronized void writeToSink(String message) {
        System.out.println(message+ " : [ConsoleWrite]");
    }
}
