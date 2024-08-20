package com.company.designpattern.factory;

class CarFactory implements VehicleAbstractFactory {
    @Override
    public Vehicle createVehicle(String company) {
        if (company.equalsIgnoreCase("Maruti")) {
            return new Car();
        } else if (company.equalsIgnoreCase("Audi")) {
            return new Car();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + company);
        }
    }
}
