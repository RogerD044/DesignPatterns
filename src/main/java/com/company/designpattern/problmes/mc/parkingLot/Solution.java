package com.company.designpattern.problmes.mc.parkingLot;


/*
Provide code for a parking lot with the following assumptions,

• The parking lot has multiple levels. Each level has multiple rows of spots.
• The parking lot has motorcycle spots and car spots.
• A motorcycle can park in any empty spot.
• A car can only park in a single empty car spot.


Provide 3 functions for a working parking lot:

Given a vehicle, you should be able to park it.
Given a vehicle, you should be able to unpark it.
Given a spot, you should be able to find the vehicle parked in it.
*/


/*
Vehicle
    id
    Vehicletype
    owner
    lisence_number

ParkingLot
    <ParkingLevel>
    park()
    unpark()
    findVehicleAtSpot(Vehicle)

ParkingLevel
    levelId
    ParkingSpots

ParkingSpot
    id
    isAvailable
    SpotType

Booking
    id
    vehicle
    levelId
    spotId
    startTime


*/

import java.util.*;

class Vehicle {
    int id;
    Vehicletype vehicletype;

    public Vehicle(int id, Vehicletype vehicletype) {
        this.id = id;
        this.vehicletype = vehicletype;
    }

    public Vehicletype getType() {
        return vehicletype;
    }

    public int getId() {
        return id;
    }
}

class ParkingSpot {
    int spotId;
    boolean isAvailable;
    Vehicletype vehicletype;
    Vehicle vehicle;


    public ParkingSpot(int id, Vehicletype vehicletype) {
        this.spotId = id;
        this.vehicletype = vehicletype;
        this.isAvailable = true;
        this.vehicle = null;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public Vehicletype getType() {
        return vehicletype;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.isAvailable = false;
        this.vehicle = vehicle;
    }

    public void clearVehicle() {
        this.isAvailable = true;
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

class ParkingLevel {
    int levelId;
    List<ParkingSpot> spots;

    public ParkingLevel(int id, List<ParkingSpot> spots) {
        this.levelId = id;
        this.spots = spots;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }
}

class Booking {
    int vehicleId;
    int levelId;
    int spotId;
    long startTime;

    public Booking(int vehicleId, int levelId, int spotId) {
        this.vehicleId = vehicleId;
        this.levelId = levelId;
        this.spotId = spotId;
        // startTime = System.currentTimeInMillis();
    }

    public int getLevelId() {
        return levelId;
    }

    public int getSpotId() {
        return spotId;
    }
}

// interface ParkingStrategy {
//     Booking findSpot(Vehicle, List<ParkingLevel> levels);
// }

// class MyParkingStrategy implements ParkingStrategy {
//     public Booking findSpot(Vehicle, List<ParkingLevel> levels) {

//     }
// }

class ParkingLot {
    List<ParkingLevel> levels;
    Map<Vehicle, Booking> currentBookings;
    Map<Integer,Map<Integer,ParkingSpot>> spotBookings;

    public ParkingLot(List<ParkingLevel> levels) {
        this.levels = levels;
        this.currentBookings = new HashMap<>();
        this.spotBookings = new HashMap<>();
    }

    public void park(Vehicle vehicle) {
        ParkingSpot availableSpot = null;
        int currLevel = 0;
        for(int i=0;i<levels.size();++i) {
            ParkingLevel level = levels.get(i);
            currLevel = i;

            // If this level has empty Spot;
            for(ParkingSpot spot : level.getSpots()) {
                if(spot.getAvailability() && spot.getType().equals(vehicle.getType())) {
                    availableSpot = spot;
                    break;
                }
            }

            if(availableSpot!=null)
                break;
        }

        if(availableSpot==null) {
            System.out.println("Lot Full");
            return;
        }

        Booking response = new Booking(vehicle.getId(), currLevel, availableSpot.getSpotId());
        currentBookings.put(vehicle, response);

        availableSpot.setVehicle(vehicle);

        Map<Integer, ParkingSpot> spotBooking = new HashMap<>();
        spotBooking.put(availableSpot.getSpotId(), availableSpot);
        spotBookings.put(currLevel,spotBooking);
    }

    public void unpark(Vehicle vehicle) {
        Booking booking  = currentBookings.getOrDefault(vehicle,null);
        if(booking==null) {
            System.out.println("Vehicle not in ststem");
            return;
        }

        int spotId = booking.getSpotId();
        int level = booking.getLevelId();
        ParkingSpot parkedSpot = null;
        if(spotBookings.containsKey(level) && spotBookings.get(level).containsKey(spotId))
            parkedSpot = spotBookings.get(level).get(spotId);

        parkedSpot.clearVehicle();

        // Remove from bookings
        currentBookings.remove(vehicle);
        spotBookings.get(level).remove(spotId);
    }

    public void getVehicleFromSpot(int levelId, int spotId) {
        ParkingSpot parkedSpot = null;
        if(spotBookings.containsKey(levelId) && spotBookings.get(levelId).containsKey(spotId))
            parkedSpot = spotBookings.get(levelId).get(spotId);

        if(parkedSpot==null) {
            System.out.println("Spot not booked");
            return;
        }

        Vehicle vehicle = parkedSpot.getVehicle();
        System.out.println(vehicle.getId());
    }
}

enum Vehicletype {
    BIKE, CAR
}

// Main class should be named 'Solution' and should not be public.
class Solution {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle(1, Vehicletype.BIKE);
        Vehicle car = new Vehicle(2, Vehicletype.CAR);

        ParkingSpot spot1 = new ParkingSpot(1, Vehicletype.BIKE);
        ParkingSpot spot2 = new ParkingSpot(2, Vehicletype.CAR);
        ParkingSpot spot3 = new ParkingSpot(3, Vehicletype.BIKE);
        ParkingSpot spot4 = new ParkingSpot(4, Vehicletype.CAR);

        ParkingLevel level1 = new ParkingLevel(1, Arrays.asList(spot1,spot2));
        ParkingLevel level2 = new ParkingLevel(2, Arrays.asList(spot3,spot4));

        ParkingLot lot = new ParkingLot(Arrays.asList(level1,level2));

        lot.park(bike);
        lot.park(car);

        lot.getVehicleFromSpot(0,1);
    }
}