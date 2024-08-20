package com.company.designpattern.problmes.mc.flipkartUPI.filter;

import com.company.designpattern.problmes.mc.flipkartUPI.Transaction;
import com.company.designpattern.problmes.mc.flipkartUPI.TransactionStatus;

import java.util.List;
import java.util.stream.Collectors;

public class StatusFilter implements Filter{
    private List<TransactionStatus> statuses;
    public StatusFilter(List<TransactionStatus> statuses) {
        this.statuses = statuses;
    }

    @Override
    public List<Transaction> filter(List<Transaction> transactions) {
        if(statuses==null || statuses.size()==0)
            return transactions;
        return transactions.stream().filter(t -> statuses.contains(t.getStatus())).collect(Collectors.toList());
    }
}
