package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static void main(String[] args) throws Exception {
        WarehouseManager warehouseManager = new WarehouseManager(new SimpleSlotSelectionStrategy());

        SellerManager sellerManager = new SellerManager();
        ProductManager productManager = new ProductManager();

        Seller s1 = sellerManager.register("s1","s_name","s_email");
        Seller s2 = sellerManager.register("s2","s_name","s_email");
        Seller s3 = sellerManager.register("s3","s_name","s_email");
        Seller s4 = sellerManager.register("s4","s_name","s_email");

        Product p1 = productManager.createProduct("p1","p_name",10);
        Product p2 = productManager.createProduct("p2","p_name",10);
        Product p3 = productManager.createProduct("p3","p_name",10);
        Product p4 = productManager.createProduct("p4","p_name",10);

        warehouseManager.addWarehouse("blr_wh","blr_wh");
        warehouseManager.addCapacity("blr_wh",1, 100);
        warehouseManager.addCapacity("blr_wh",2, 170);
        warehouseManager.addCapacity("blr_wh",3, 80);

        warehouseManager.addWarehouse("delhi_wh","delhi_wh");
        warehouseManager.addCapacity("delhi_wh",3, 300);

        warehouseManager.getCapacity("delhi_wh",1);

        warehouseManager.onboardSellerToWarehouse(s1.getId(),"blr_wh");
        warehouseManager.onboardSellerToWarehouse(s1.getId(),"delhi_wh");

        Map<String, Integer> c1 = new HashMap<>();
        c1.put(p1.getProductId(),50);
        c1.put(p2.getProductId(),110);
        warehouseManager.getSlots(s1.getId(),1,c1);

        warehouseManager.reserve(s1,"delhi_wh",c1,3);

        warehouseManager.reserve(s2,"delhi_wh",c1,3);



    }
}
