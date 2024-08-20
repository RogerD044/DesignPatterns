package com.company.designpattern.factory;

class TruckFactory implements VehicleAbstractFactory {
    @Override
    public Vehicle createVehicle(String company) {
        if (company.equalsIgnoreCase("Bharat Benz")) {
            return new Truck();
        } else if (company.equalsIgnoreCase("Ashok Leyland")) {
            return new Truck();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type: " + company);
        }
    }
}
