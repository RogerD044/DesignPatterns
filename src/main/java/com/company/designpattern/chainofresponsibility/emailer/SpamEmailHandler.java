package com.company.designpattern.chainofresponsibility.emailer;

class SpamEmailHandler extends Handler {

    public SpamEmailHandler(Handler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.SPAM) {
            System.out.println("Spam email handled");
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}

