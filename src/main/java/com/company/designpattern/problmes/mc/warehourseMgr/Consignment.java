package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.Map;

public class Consignment {
    private Seller seller;
    private Map<String, Integer> itemList;
    private double cost;

    public Consignment(Map<String, Integer> itemList, Seller seller) {
        this.seller = seller;
        this.itemList = itemList;
        this.cost = calculateCost();
    }

    private double calculateCost() {
        int units = 0;
        for(Integer slots : itemList.values())
            units+=slots;

        return (units * 10 - (10 * seller.getRating()));
    }

    public int getUnits() {
        int units = 0;
        for(Integer slots : itemList.values())
            units+=slots;
        return units;
    }

    public double getCost() {
        return cost;
    }
}
