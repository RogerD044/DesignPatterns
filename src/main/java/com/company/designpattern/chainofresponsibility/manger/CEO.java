package com.company.designpattern.chainofresponsibility.manger;

// Concrete handler 3
class CEO extends Handler {
    public CEO(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        System.out.println("CEO can approve any request.");
    }
}