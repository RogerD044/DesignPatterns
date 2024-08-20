package com.company.designpattern.problmes.mc.flipkartUPI;

public class HDFCBank extends IBankingService{
    public BankAccount createAccount(Bank bank,String accNumber, User user) {
        return new BankAccount(bank, accNumber,user);
    }
}
