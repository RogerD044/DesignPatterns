package com.company.designpattern.chainofresponsibility.manger;

public class MangerDriver {
    public static void drive() {
        // Creating chain of responsibility
        Handler ceo = new CEO(null);
        Handler director = new Director(ceo);
        Handler manager = new Manager(director);


        // Handling requests
        Request request1 = new Request(50);
        manager.handleRequest(request1);

        Request request2 = new Request(200);
        manager.handleRequest(request2);

        Request request3 = new Request(1000);
        manager.handleRequest(request3);
    }
}
