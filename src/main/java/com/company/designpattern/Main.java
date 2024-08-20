package com.company.designpattern;

import com.company.designpattern.chainofresponsibility.emailer.EmailerDriver;
import com.company.designpattern.chainofresponsibility.manger.MangerDriver;

public class Main {

    public static void main(String[] args) {
        // Chain of Responsibility Pattern
        // Manager Example
        MangerDriver.drive();
        // Emailer Example
        EmailerDriver.drive();
    }
}
