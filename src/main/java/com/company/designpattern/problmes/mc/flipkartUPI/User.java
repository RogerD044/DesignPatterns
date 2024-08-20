package com.company.designpattern.problmes.mc.flipkartUPI;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String phone;
    private Set<BankAccount> bankAccounts;
    private List<Transaction> transactions;
    private UserStatus status;


    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.status = UserStatus.ACTIVE;
        this.bankAccounts = new HashSet<>();
        this.transactions = new ArrayList<>();
    }

    public  Set<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public  List<Transaction> getTransactions() {
        return transactions;
    }

    public String getPhone() {
        return phone;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserStatus getStatus() {
        return status;
    }





}
