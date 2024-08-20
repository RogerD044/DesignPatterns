package com.company.designpattern.singleton;

public class EagerSingletonDriver {
    // Created During Class Loading
    private static EagerSingletonDriver instance = new EagerSingletonDriver();

    private EagerSingletonDriver() {}

    public static EagerSingletonDriver getInstance() {
        return instance;
    }

}
