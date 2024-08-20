package com.company.designpattern.factory;

interface VehicleFactory {
    // Factory method to create vehicles
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("Truck")) {
            return new Truck();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + type);
        }
    }
}
