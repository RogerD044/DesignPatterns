package com.company.designpattern.problmes.mc.flipkartUPI;

import java.util.*;

public abstract class IBankingService {

    private HashMap<String, Bank> bankMap;

    public IBankingService() {
        this.bankMap = new HashMap<>();
    }

    public abstract BankAccount createAccount(Bank bank,String accNumber, User user);

    public void registerBank(String name, boolean isAvailable) throws Exception {
        if(bankMap.containsKey(name))
            throw new Exception("Bank exists");
        Bank b = new Bank(name, isAvailable);
        bankMap.put(name,b);
    }

    public void markAvailability(Bank bank, boolean avail) {
        bank.setAvailability(avail);
    }

    public Bank getBank(String name) throws Exception {
        if(!bankMap.containsKey(name))
            throw new Exception("No Bank exists");
        return bankMap.get(name);
    }

    public boolean addBalance(BankAccount account, double amount) {
        account.incrementBalance(amount);
        return true;
    }

    public boolean deductBalance(BankAccount account, double amount) {
        account.decrementBalance(amount);
        return true;
    }
}
