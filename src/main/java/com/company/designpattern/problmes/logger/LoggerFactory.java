package com.company.designpattern.problmes.logger;

import java.util.*;

public class LoggerFactory {
    public Logger getLogger(String df, LogLevel level, LoggerType type, Sink sink, Integer buffer) {
        if(type==LoggerType.SYNC) {
            return createChainOfSyncLoggers(df,level,sink);
        } else if(type==LoggerType.ASYNC) {
            return createChainOfAsyncLoggers(df,level,sink,buffer);
        }

        return null;
    }

    private Logger createChainOfSyncLoggers(String df, LogLevel logLevel, Sink sink) {
        List<LogLevel> levels = Arrays.asList(LogLevel.values());
        Collections.reverse(levels);
        List<Logger> loggers = new ArrayList<>();
        for(LogLevel level : levels) {
            loggers.add(new SyncLogger(level,sink,df));
        }

        Logger prevLogger = null;
        for(Logger logger : loggers) {
            if(prevLogger!=null) {
                prevLogger.setNextLogLevel(logger);
            }

            if(logger.logLevel.name().equals(logLevel.name())) {
                break;
            }

            prevLogger = logger;
        }

        return loggers.get(0);
    }

    private Logger createChainOfAsyncLoggers(String df, LogLevel logLevel, Sink sink, int buffer) {
        List<LogLevel> levels = Arrays.asList(LogLevel.values());
        Collections.reverse(levels);
        List<Logger> loggers = new ArrayList<>();
        for(LogLevel level : levels) {
            loggers.add(new AsyncLogger(level,sink,df,buffer));
        }

        Logger prevLogger = null;
        for(Logger logger : loggers) {
            if(prevLogger!=null) {
                prevLogger.setNextLogLevel(logger);
            }


            if(logger.logLevel.name().equals(logLevel.name())) {
                break;
            }

            prevLogger = logger;
        }

        return loggers.get(0);

    }


}
