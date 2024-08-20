package com.company.designpattern.factory;

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}