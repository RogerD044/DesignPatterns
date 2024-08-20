package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private String warehouseId;
    private String name;
    private Map<Integer, Capacity> capacityMap;

    public Warehouse(String warehouseId, String name) {
        this.capacityMap = new HashMap<>();
        this.name = name;
        this.warehouseId = warehouseId;
    }

    public Map<Integer, Capacity> getCapacityMap() {
        return capacityMap;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(warehouseId).append(" | ").append(name).append(" | ");
        capacityMap.keySet().forEach(k -> sb.append(k).append(" :: ").append(capacityMap.get(k).toString()));
        return sb.toString();

    }
}
