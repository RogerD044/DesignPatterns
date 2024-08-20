package com.company.designpattern.problmes.cache;

public class Testing {

    public static void main(String[] args) {
        new Thread(Testing::f1).start();
        new Thread(Testing::f2).start();
        new Thread(Testing::f1).start();
        new Thread(Testing::f2).start();
        new Thread(Testing::f1).start();
        new Thread(Testing::f2).start();
        new Thread(Testing::f1).start();
        new Thread(Testing::f2).start();
        new Thread(Testing::f1).start();
        new Thread(Testing::f2).start();


    }

    public static synchronized void f1() {
        try { Thread.sleep(2000);
        System.out.println("Inside func 1 "+Thread.currentThread().getName());
                } catch (Exception e) {}
    }

    public static synchronized void f2() {
        try { Thread.sleep(2000);
            System.out.println("Inside func 2 "+Thread.currentThread().getName());
        } catch (Exception e) {}
    }
}
