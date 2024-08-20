package com.company.designpattern.chainofresponsibility.emailer;

public class Request {
    private RequestType type;

    public Request(RequestType type) {
        this.type = type;
    }

    public RequestType getType() {
        return type;
    }
}

// Enum for different request types

enum RequestType {
    SPAM,
    IMPORTANT
}