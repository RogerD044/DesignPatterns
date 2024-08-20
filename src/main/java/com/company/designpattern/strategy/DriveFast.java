package com.company.designpattern.strategy;

class DriveFast implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving Fast");
    }
}
