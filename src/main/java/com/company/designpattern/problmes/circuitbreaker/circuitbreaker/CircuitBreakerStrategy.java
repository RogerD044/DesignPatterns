package com.company.designpattern.problmes.circuitbreaker.circuitbreaker;

import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.model.CircuitBreakerState;
import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.model.Record;
import com.company.designpattern.problmes.circuitbreaker.exceptions.CallNotPermittedException;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public abstract class CircuitBreakerStrategy<T> {

    protected Queue<Record> queue;
    protected CircuitBreakerState state;
    protected long minimumRequests = 10;
    protected long countBasedSlidingWindowThresholdInMillis = 100;
    protected AtomicLong failureCount;
    protected long slowResponseThresholdInMillis = 250;
    protected double closedToOpenThresholdPercent = 0.5;
    protected int halfOpenToClosedThreshold = 10;
    protected int halfOpenToOpenThreshold = 10;
    protected long openToHalfOpenTimeoutInMillis = 3000;
    protected long openStateEndingTimeInMillis;

    public CircuitBreakerStrategy() {
        this.queue = new LinkedBlockingQueue<>();
        this.state = CircuitBreakerState.CLOSED;
        this.failureCount = new AtomicLong(0);
    }

    protected abstract boolean allowRequest() throws CallNotPermittedException;
    protected abstract void markRequest(Record record) throws CallNotPermittedException;

    protected synchronized void moveToOpenState() {
        System.out.println("Moving from "+state+" - "+CircuitBreakerState.OPEN.name()+" | Time : "+new Date().toString());
        state = CircuitBreakerState.OPEN;
        queue.clear();
        failureCount.set(0);
        openStateEndingTimeInMillis = System.currentTimeMillis() + openToHalfOpenTimeoutInMillis;
    }

    protected synchronized void moveToClosedState() {
        System.out.println("Moving from "+state+" - "+CircuitBreakerState.CLOSED.name()+" | Time : "+new Date().toString());
        state = CircuitBreakerState.CLOSED;
        queue.clear();
        failureCount.set(0);
    }

    protected synchronized void moveToHalfOpenState() {
        System.out.println("Moving from "+state+" - "+CircuitBreakerState.HALF_OPEN.name()+" | Time : "+new Date().toString());
        state = CircuitBreakerState.HALF_OPEN;
        queue.clear();
        failureCount.set(0);
    }
}
