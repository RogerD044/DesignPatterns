package com.company.designpattern.problmes.mc.flipkartUPI;

import lombok.ToString;

import java.util.*;

@ToString
public class Transaction {
    private String id;
    private User sender;
    private BankAccount senderBankAccount;
    private User receiver;
    private BankAccount receiverBankAccount;
    private double amount;
    private TransactionStatus status;
    private Date createdAt;

    public Transaction(User u1, User u2, double amount, BankAccount senderBankAccount, BankAccount receiverBankAccount) {
        this.sender = u1;
        this.sender = u2;
        this.amount = amount;
        this.status = TransactionStatus.CREATED;
        this.createdAt = new Date();
        this.senderBankAccount = senderBankAccount;

        this.receiverBankAccount = receiverBankAccount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }
}
