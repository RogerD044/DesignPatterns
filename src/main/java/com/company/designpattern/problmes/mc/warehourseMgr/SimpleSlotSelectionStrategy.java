package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleSlotSelectionStrategy implements SlotStrategy{

    @Override
    public Map<String, Integer> findSlots(List<Warehouse> warehouseList, int date, int requiredSlots) {
        Map<String, Integer> response = new HashMap<>();
        for(Warehouse warehouse: warehouseList) {
            for(Integer slotDate : warehouse.getCapacityMap().keySet()) {
                if(slotDate>=date && warehouse.getCapacityMap().get(slotDate).getAvailableSlots() > requiredSlots) {
                    response.put(warehouse.getWarehouseId(),slotDate);
                }
            }
        }

        return response;
    }
}
