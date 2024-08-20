package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.List;
import java.util.Map;

public interface SlotStrategy {
    Map<String, Integer> findSlots(List<Warehouse> warehouseList, int date, int requiredSlots);
}
