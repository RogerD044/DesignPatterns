package com.company.designpattern.problmes.circuitbreaker.exceptions;

public class SlowResponseException extends Exception{
    public SlowResponseException(String msg) {
        super(msg);
    }
}
