package com.company.designpattern.problmes.customThreadpool.exception;

public class QueueFullException extends Exception {
    public QueueFullException(String message) {
        super(message);
    }
}
