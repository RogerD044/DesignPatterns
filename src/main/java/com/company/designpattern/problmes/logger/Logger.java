package com.company.designpattern.problmes.logger;

import java.time.LocalDateTime;

public abstract class Logger {
    protected LogLevel logLevel;
    protected Sink sink;
    protected String dateFormat;
    protected Logger nexLogger;

    public Logger(LogLevel level, Sink sink,String dateFormat) {
        this.logLevel = level;
        this.sink = sink;
        this.dateFormat = dateFormat;
    }

    public void setNextLogLevel(Logger logger) {
        this.nexLogger = logger;
    }

    protected abstract void log(LogLevel logLevel, String message);

    protected String wrapMessage(String message) {
        return LocalDateTime.now() + " [" + this.logLevel.name()+"] " + message;
    }

    protected void logMessage(LogLevel logLevel, String message) {
        if(this.logLevel.ordinal()== logLevel.ordinal())
            sink.writeToSink(wrapMessage(message));
        else if(this.nexLogger!=null)
            this.nexLogger.logMessage(logLevel,message);
    }

    public void error(String message) {
        log(LogLevel.ERROR,message);
    }

    public void warn(String message) {
        log(LogLevel.WARN,message);
    }

    public void info(String message) {
        log(LogLevel.INFO,message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG,message);
    }

    public void all(String message) {
        log(LogLevel.ALL,message);
    }
}
