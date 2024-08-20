package com.company.designpattern.factory;

public class FactoryDriverClass {
    public static void main() {
        // Factory Example
        Vehicle car = VehicleFactory.createVehicle("Car");
        Vehicle truck = VehicleFactory.createVehicle("Truck");

        // Abstract Factory Example
        VehicleAbstractFactory carFactory = new CarFactory();
        VehicleAbstractFactory truckFactory = new TruckFactory();

        Vehicle car1 = carFactory.createVehicle("Audi");
        Vehicle car2 = carFactory.createVehicle("Maruti");

        Vehicle truck1 = truckFactory.createVehicle("Bharat Benz");
        Vehicle truck2 = truckFactory.createVehicle("Ashok Leyland");
    }
}
