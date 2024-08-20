package com.company.designpattern.problmes.mc.flipkartUPI;

public class Bank {
    private String name;
    private boolean isAvailable;

    public Bank(String name,boolean isAvailable) {
        this.isAvailable = isAvailable;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean getAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
