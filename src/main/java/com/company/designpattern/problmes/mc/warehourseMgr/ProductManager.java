package com.company.designpattern.problmes.mc.warehourseMgr;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    Map<String, Product> productMap;

    public ProductManager() {
        this.productMap = new HashMap<>();
    }

    public Product createProduct(String id, String name, double price) throws Exception {
        if(productMap.containsKey(id))
            throw new Exception("Product Id exists");

        Product product = new Product(id, name,price);
        System.out.println(product.toString());
        productMap.put(id, product);
        return product;
    }

    public Product getProduct(String id) throws Exception {
        if(!productMap.containsKey(id))
            throw new Exception("Product Id doesnt exists");

        return productMap.get(id);
    }
}
