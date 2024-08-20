package com.company.designpattern.strategy;

class DriveSlow implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Driving slowly");
    }
}
