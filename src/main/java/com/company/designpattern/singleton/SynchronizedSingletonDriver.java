package com.company.designpattern.singleton;

public class SynchronizedSingletonDriver {
    private static SynchronizedSingletonDriver instance = null;

    synchronized public static SynchronizedSingletonDriver getInstance() {
        if(instance==null)
            instance = new SynchronizedSingletonDriver();

        return instance;
    }
}
