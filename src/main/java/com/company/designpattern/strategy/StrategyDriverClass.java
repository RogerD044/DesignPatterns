package com.company.designpattern.strategy;

public class StrategyDriverClass {
    public static void main() {
        // Creating vehicle objects with different drive strategies
        Vehicle slowVehicle = new Vehicle(new DriveSlow());
        Vehicle fastVehicle = new Vehicle(new DriveFast());

        // Using the strategies
        slowVehicle.drive(); // Output: Driving slowly
        fastVehicle.drive(); // Output: Driving fast

        // Changing strategy at runtime
        slowVehicle.setDriveStrategy(new DriveFast());
        slowVehicle.drive(); // Output: Driving fast
    }
}
