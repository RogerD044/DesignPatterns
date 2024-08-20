package com.company.designpattern.problmes.logger;

public class SyncLogger extends Logger{

    public SyncLogger(LogLevel level, Sink sink,String dateFormat) {
        super(level,sink,dateFormat);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        logMessage(logLevel,message);
    }
}
