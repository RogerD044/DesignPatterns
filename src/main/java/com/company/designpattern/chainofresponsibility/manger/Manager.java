package com.company.designpattern.chainofresponsibility.manger;

// Concrete handler 1
class Manager extends Handler {
    public Manager(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getAmount() <= 100) {
            System.out.println("Manager can approve the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("No one can handle the request.");
        }
    }
}