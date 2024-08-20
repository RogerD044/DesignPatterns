package com.company.designpattern.chainofresponsibility.manger;

// Concrete handler 2
class Director extends Handler {
    public Director(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getAmount() <= 500) {
            System.out.println("Director can approve the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No one can handle the request.");
        }
    }
}