package com.company.designpattern.chainofresponsibility.emailer;

public class EmailerDriver {
    public static void drive() {
        Handler spamHandler = new SpamEmailHandler(null);
        Handler importantHandler = new ImportantEmailHandler(spamHandler);

        Request request1 = new Request(RequestType.SPAM);
        Request request2 = new Request(RequestType.IMPORTANT);

        importantHandler.handleRequest(request1);
        importantHandler.handleRequest(request2);
    }
}
