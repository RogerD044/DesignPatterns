package com.company.designpattern.chainofresponsibility.manger;

// Handler interface
abstract class Handler {
    Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void handleRequest(Request request);
}