package com.company.designpattern.problmes.circuitbreaker.exceptions;

public class ServiceUnavailable extends Exception{
    public ServiceUnavailable(String msg) {
        super(msg);
    }
}
