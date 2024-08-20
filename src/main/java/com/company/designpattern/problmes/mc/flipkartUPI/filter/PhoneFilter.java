package com.company.designpattern.problmes.mc.flipkartUPI.filter;

import com.company.designpattern.problmes.mc.flipkartUPI.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneFilter implements Filter{
    private List<String> payeePhoneNumber;
    public PhoneFilter(List<String> payeePhoneNumber) {
        this.payeePhoneNumber = payeePhoneNumber;
    }

    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        if(payeePhoneNumber==null || payeePhoneNumber.size()==0)
            return transactions;
        return transactions.stream().filter(t -> payeePhoneNumber.contains(t.getReceiver().getPhone())).collect(Collectors.toList());
    }
}
