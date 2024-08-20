package com.company.designpattern.problmes.mc.flipkartUPI;

import com.company.designpattern.problmes.mc.flipkartUPI.filter.Filter;
import com.company.designpattern.problmes.mc.flipkartUPI.filter.FilterRequest;
import com.company.designpattern.problmes.mc.flipkartUPI.filter.PhoneFilter;
import com.company.designpattern.problmes.mc.flipkartUPI.filter.StatusFilter;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PaymentServerProvider {
    private IBankingService bankingService;
    private HashMap<String, BankAccount> accountMap;
    private Lock lock = new ReentrantLock();
    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public PaymentServerProvider(IBankingService bankingService) {
        this.accountMap = new HashMap<>();
        this.bankingService =  bankingService;
    }


    public synchronized Transaction makePayment(User u1, User u2, double amount) throws Exception{
        BankAccount senderAccount = getPrimaryBankAccount(u1);
        BankAccount receiverAccount = getPrimaryBankAccount(u2);
        if(senderAccount==null || receiverAccount == null)
            throw new Exception("Primary Bank does not exists");
        if(senderAccount.getBalance()<amount || senderAccount.getBank().getAvailability() || receiverAccount.getBank().getAvailability()) {
            throw new Exception("balance / server unavailable");
        }

        Transaction t = new Transaction(u1, u2,amount,senderAccount,receiverAccount);

        executorService.submit(() -> makePaymentUtil(t,senderAccount,receiverAccount,amount));

        return t;
    }

    private synchronized void makePaymentUtil(Transaction t, BankAccount senderAccount, BankAccount receiverAccount, double amount) {
        System.out.println("Tx Start" + t.toString());

        try { Thread.sleep(3000); } catch (Exception e) { e.printStackTrace(); }

        boolean sendSuccess = bankingService.deductBalance(senderAccount,amount);
        boolean receiveSuccess = false;

        if(sendSuccess)
            receiveSuccess = bankingService.addBalance(receiverAccount,amount);

        if(sendSuccess && !receiveSuccess)
            bankingService.addBalance(senderAccount,amount);

        if(!sendSuccess || !receiveSuccess)
            t.setStatus(TransactionStatus.FAILURE);
        else
            t.setStatus(TransactionStatus.SUCCESS);

        System.out.println("Tx end" + t.toString());
    }

    private BankAccount getPrimaryBankAccount(User u) {
        for(BankAccount bankAccount : u.getBankAccounts()) {
            if(bankAccount.isPrimary())
                return bankAccount;
        }

        return null;
    }

    public List<Transaction> fetchTransaction(FilterRequest request, User user) {
        Filter phoneFilter = new PhoneFilter(request.getPhones());
        Filter statusFilter = new StatusFilter(request.getStatuses());

        return statusFilter.filter(phoneFilter.filter(user.getTransactions()));
    }

    public void linkBankAccount(User user, BankAccount bankAccount, boolean isPrimary) {
        if(isPrimary)
            bankAccount.setPrimary();

        user.getBankAccounts().forEach(BankAccount::unsetPrimary);
        user.getBankAccounts().add(bankAccount);
    }


}
