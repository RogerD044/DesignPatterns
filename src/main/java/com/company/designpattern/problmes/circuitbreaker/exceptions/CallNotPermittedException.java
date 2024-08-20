package com.company.designpattern.problmes.circuitbreaker.exceptions;

public class CallNotPermittedException extends Exception{
    public CallNotPermittedException(String messgae) {
        super(messgae);
    }
}
