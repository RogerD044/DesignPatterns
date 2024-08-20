package com.company.designpattern.problmes.mc.flipkartUPI;

public class SBIBank extends IBankingService{
    public BankAccount createAccount(Bank bank,String accNumber, User user) {
        return new BankAccount(bank, accNumber,user);
    }
}
