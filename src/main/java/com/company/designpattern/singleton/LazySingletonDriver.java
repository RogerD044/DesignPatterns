package com.company.designpattern.singleton;

public class LazySingletonDriver {
    private static LazySingletonDriver instance = null;

    private LazySingletonDriver() {}

    public static LazySingletonDriver getInstance() {
        if(instance==null)
            instance = new LazySingletonDriver();

        return instance;
    }
}
