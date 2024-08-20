package com.company.designpattern.chainofresponsibility.emailer;

abstract class Handler {
    protected Handler nextHandler;

    public Handler(Handler next) {
        this.nextHandler = next;
    }

    public abstract void handleRequest(Request request);
}
