package com.company.designpattern.problmes.mc.warehourseMgr;

public class Capacity {
    private int total;
    private int booked;

    public Capacity() {
        this.booked = 0;
        this.total = 0;
    }

    public void addCapacity(int cap) {
        total+=cap;
    }

    public void reserve(int slots) {
        booked+=slots;
    }

    public int getAvailableSlots() {
        return total-booked;
    }

    @Override
    public String toString() {
        return "Total: "+total + " | Booked : "+booked;
    }
}
