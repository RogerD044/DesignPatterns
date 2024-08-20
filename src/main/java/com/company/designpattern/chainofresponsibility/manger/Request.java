package com.company.designpattern.chainofresponsibility.manger;

// Request Class
class Request {
    private int amount;

    public Request(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}