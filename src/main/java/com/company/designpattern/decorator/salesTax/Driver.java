package com.company.designpattern.decorator.salesTax;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();

        Item bookItem = new Item("Book1",10.0,ProductType.BOOK,false);
        Item music = new BasicSalesTaxDecorator(new Item("Music1",10.0,ProductType.MUSIC,false));
        Item chocolate = new BasicSalesTaxDecorator(new Item("Chock",10.0,ProductType.CHOCOLATE,false));
        Item importedChocolate = new ImportTaxDecorator(new BasicSalesTaxDecorator(new Item("Chock1",10.0,ProductType.CHOCOLATE,true)));

        receipt.addToReceipt(bookItem);
        receipt.addToReceipt(music);
        receipt.addToReceipt(chocolate);
        receipt.addToReceipt(importedChocolate);
        receipt.printReceipt();
    }
}

class Payable {
    private List<Pair<String, Double>> payable;

    public Payable() {
        payable = new ArrayList<>();
    }

    List<Pair<String, Double>> getPayables() {
        return payable;
    }
}

class Item {
    private String name;
    private double price;
    private ProductType type;
    private boolean isImported;

    public Item(String name, double price, ProductType type, boolean isImported) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.isImported = isImported;
    }

    String getName() {
        return this.name;
    }

    double getItemPrice() {
        return this.price;
    }

    ProductType getType() {
        return this.type;
    }

    boolean isImported() {
        return this.isImported;
    }

    Payable getPayable() {
        Payable payable = new Payable();
        payable.getPayables().add(new Pair<>("Base",price));
        return payable;
    }
}

enum ProductType{
    BOOK, GAME, CHOCOLATE, PERFUME, MUSIC
}

abstract class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        super(item.getName(),item.getItemPrice(),item.getType(),item.isImported());
        this.item = item;
    }
}

class BasicSalesTaxDecorator extends ItemDecorator {
    private static final double TAX_RATE = 0.1;

    public BasicSalesTaxDecorator(Item item) {
        super(item);
    }

    @Override
    Payable getPayable() {
        Payable payable = item.getPayable();
        payable.getPayables().add(new Pair<>("Sales Tax", item.getItemPrice() * TAX_RATE));
        return payable;
    }
}

class ImportTaxDecorator extends ItemDecorator {
    private static final double TAX_RATE = 0.05;

    public ImportTaxDecorator(Item item) {
        super(item);
    }


    @Override
    Payable getPayable() {
        Payable payable = item.getPayable();
        payable.getPayables().add(new Pair<>("Import Duty Tax", item.getItemPrice() * TAX_RATE));
        return payable;
    }
}

class Receipt {
    List<Item> itemList;

    public Receipt() {
        this.itemList = new ArrayList<>();
    }

    void addToReceipt(Item item) {
        itemList.add(item);
    }

    void printReceipt() {
        for(Item item : itemList) {
            for(Pair<String,Double> pair : item.getPayable().getPayables()) {
                System.out.print(pair.fst+" : "+pair.snd+" | ");
            }

            System.out.println();
        }
    }
}