package com.company.designpattern.chainofresponsibility.emailer;

import com.company.designpattern.chainofresponsibility.emailer.Handler;

class ImportantEmailHandler extends Handler {

    public ImportantEmailHandler(Handler next) {
        super(next);
    }

    @Override
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.IMPORTANT) {
            System.out.println("Important email handled");
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        }
    }
}
