package com.company.designpattern.problmes.mc.flipkartUPI;

public class Dri {
    public static void main(String[] args) throws Exception {
        UserManager userManager = new UserManager();
        User u1 = userManager.registerUser("1","1");
        User u2 = userManager.registerUser("1","1");

        IBankingService bankingService1 = new HDFCBank();
        IBankingService bankingService2 = new SBIBank();

//        bank1.createAccount(bank1,"acc1",u2);

//        PaymentServerProvider paymentServerProvider = new PaymentServerProvider();
//        paymentServerProvider.makePayment();
//        paymentServerProvider.linkBankAccount();
//        paymentServerProvider.fetchTransaction()
    }
}
