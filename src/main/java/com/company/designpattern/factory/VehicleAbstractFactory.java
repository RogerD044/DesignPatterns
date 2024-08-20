package com.company.designpattern.factory;

interface VehicleAbstractFactory {
    // Factory method to create vehicles
    Vehicle createVehicle(String companyName);
}
