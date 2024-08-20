package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    private String id;
    private String name;
    private String email;
    private List<Product> catalog;
    private int rating;
    private List<Consignment> consignments;

    public Seller(String id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.catalog = new ArrayList<>();
        this.rating = 1;
        this.consignments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Product> getCatalog() {
        return catalog;
    }

    public int getRating() {
        return rating;
    }

    public void addConsignment(Consignment consignment) {
        consignments.add(consignment);
        int totalUnits = consignments.stream().mapToInt(consignment1 -> consignment.getUnits()).sum();
        int newRating = totalUnits / 150;
        rating = Math.min(10,Math.max(1,newRating));
    }


}


