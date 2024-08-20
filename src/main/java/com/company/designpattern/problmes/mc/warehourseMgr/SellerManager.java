package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.HashMap;
import java.util.Map;

public class SellerManager {
    Map<String, Seller> sellerMap;

    public SellerManager() {
        this.sellerMap = new HashMap<>();
    }

    public Seller register(String sellerId, String name, String email) throws Exception {
        if(sellerMap.containsKey(sellerId))
            throw new Exception("Seller ALready exists");
        Seller seller = new Seller(sellerId,name,email);
        sellerMap.put(sellerId,seller);

        System.out.println(seller.toString());

        return seller;
    }

    public Seller getSeller(String id) throws Exception {
        if(!sellerMap.containsKey(id))
            throw new Exception("Seller Not Found");

        return sellerMap.get(id);
    }
}
