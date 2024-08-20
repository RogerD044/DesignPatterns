package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.*;

public class WarehouseManager {
    private Map<String,Warehouse> warehouseMap;
    private Map<String, Set<Warehouse>> sellerToWarehouseMap;
    private SlotStrategy slotStrategy;

    public WarehouseManager(SlotStrategy slotStrategy) {
        this.warehouseMap = new HashMap<>();
        this.sellerToWarehouseMap = new HashMap<>();
        this.slotStrategy = slotStrategy;
    }

    public void addWarehouse(String wId, String name) throws Exception {
        if(warehouseMap.containsKey(wId))
            throw new Exception("WID already exists");

        Warehouse wh = new Warehouse(wId,name);
        warehouseMap.put(wId, wh);
        System.out.println("WH Added "+wh.toString());

        showStats();
    }

    public Warehouse getWarehouse(String wId) throws Exception {
        if(!warehouseMap.containsKey(wId))
            throw new Exception("WID doesnt exists");
        return warehouseMap.get(wId);
    }

    public void addCapacity(String wId, int date, int capacity) {
        Warehouse wh = warehouseMap.get(wId);

        if(wh.getCapacityMap().containsKey(date)) {
            wh.getCapacityMap().get(date).addCapacity(capacity);
        } else {
            wh.getCapacityMap().put(date,new Capacity());
            wh.getCapacityMap().get(date).addCapacity(capacity);
        }

        System.out.println("Added Capacity");
        showStats();
    }

    public void getCapacity(String wId, int date) throws Exception {

        Warehouse warehouse = getWarehouse(wId);
        for(Integer dateKey : warehouse.getCapacityMap().keySet()) {
            if(dateKey>=date && warehouse.getCapacityMap().get(dateKey).getAvailableSlots() > 0)
                System.out.println(dateKey+" | "+warehouse.getCapacityMap().get(dateKey).getAvailableSlots());
        }
    }

    public void onboardSellerToWarehouse(String sellerId, String wId) throws Exception {
        Warehouse warehouse = getWarehouse(wId);

        if(sellerToWarehouseMap.containsKey(sellerId))
            sellerToWarehouseMap.get(sellerId).add(warehouse);
        else {
            Set<Warehouse> list = new HashSet<>();
            list.add(warehouse);
            sellerToWarehouseMap.put(sellerId, list);
        }
    }

    public void getSlots(String sellerId, int date, Map<String, Integer> consignment) throws Exception {
        int totalSlotsRequired = 0;
        for(Integer slots : consignment.values())
            totalSlotsRequired+=slots;
        Map<String, Integer> response = slotStrategy.findSlots(new ArrayList<>(sellerToWarehouseMap.getOrDefault(sellerId, new HashSet<>())),date,totalSlotsRequired);
        System.out.println("Slots are :");
        response.forEach((k,v)-> System.out.println(k+" : "+v));
    }

    public synchronized void reserve(Seller seller, String wId, Map<String, Integer> consignment, int date) throws Exception {
        Warehouse warehouse = getWarehouse(wId);
        if(sellerToWarehouseMap.get(seller.getId()).contains(warehouse)) {
            Consignment consgnmnt = new Consignment(consignment,seller);
            warehouse.getCapacityMap().get(date).reserve(consgnmnt.getUnits());
            seller.addConsignment(consgnmnt);
            System.out.println(consgnmnt.getCost());
        }

        showStats();
    }

    public void showStats() {
        for(Warehouse w : warehouseMap.values()) {
            System.out.println(w.toString());
        }
    }

}
