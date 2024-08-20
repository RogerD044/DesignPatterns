package com.company.designpattern.singleton;

public class DoubleLockingSingletonDriver {
    private static DoubleLockingSingletonDriver instance = null;

    public static DoubleLockingSingletonDriver getInstance() {
        if(instance==null) {
            synchronized (DoubleLockingSingletonDriver.class) {
                if (instance == null) {
                    instance = new DoubleLockingSingletonDriver();
                }
            }
        }
        return instance;
    }
}
