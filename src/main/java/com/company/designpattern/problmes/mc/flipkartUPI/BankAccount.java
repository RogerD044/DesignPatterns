package com.company.designpattern.problmes.mc.flipkartUPI;

public class BankAccount {
    private Bank bank;
    private String accountNumber;
    private double balance;
    private boolean isPrimary;
    private User user;

    public BankAccount(Bank bank,String accountNumber,User user) {
        this.balance = 0;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.user = user;
    }

    public Bank getBank() {return bank;}

    public double getBalance() {return balance;}

    public String getAccountNumber() {return accountNumber;}

    public boolean isPrimary() { return isPrimary;}

    public void setPrimary() {this.isPrimary = true;}

    public void unsetPrimary() {this.isPrimary = false;}

    public void incrementBalance(double amount) {
        this.balance +=amount;
    }

    public void decrementBalance(double amount) {
        this.balance -=amount;
    }
}
