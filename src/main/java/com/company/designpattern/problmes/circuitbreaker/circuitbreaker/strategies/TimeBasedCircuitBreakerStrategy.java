package com.company.designpattern.problmes.circuitbreaker.circuitbreaker.strategies;

import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.CircuitBreakerStrategy;
import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.model.CircuitBreakerState;
import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.model.Record;
import com.company.designpattern.problmes.circuitbreaker.exceptions.CallNotPermittedException;

public class TimeBasedCircuitBreakerStrategy<T> extends CircuitBreakerStrategy<T> {
    protected long timeBasedSlidingWindowThresholdInMillis;

    public TimeBasedCircuitBreakerStrategy(long timeBasedSlidingWindowThresholdInMillis) {
        super();
        this.timeBasedSlidingWindowThresholdInMillis = timeBasedSlidingWindowThresholdInMillis;
    }

    @Override
    protected synchronized boolean allowRequest() throws CallNotPermittedException {
        if(state.equals(CircuitBreakerState.OPEN)) {
            if(System.currentTimeMillis() > openStateEndingTimeInMillis)
                moveToHalfOpenState();
            else
                return false;
        }

        if(state.equals(CircuitBreakerState.HALF_OPEN)) {
            if(failureCount.get() > halfOpenToOpenThreshold) {
                moveToOpenState();
                return false;
            } else if(queue.size()-failureCount.get() > halfOpenToClosedThreshold) {
                moveToClosedState();
                return true;
            }
        }

        // Remove entries outside the window
        while(!queue.isEmpty() && queue.peek().getCaptureTimeInMillis() < System.currentTimeMillis() - timeBasedSlidingWindowThresholdInMillis) {
            Record record = queue.poll();
            if(record.isFailure())
                failureCount.decrementAndGet();
        }

        if(queue.size()>minimumRequests) {
            double failureRate = (failureCount.get() / (1.0 * queue.size()) );

            if (failureRate > closedToOpenThresholdPercent) {
                moveToOpenState();
                return false;
            }
        }

        return true;
    }

    @Override
    protected synchronized void markRequest(Record record) throws CallNotPermittedException {
        queue.offer(record);
        if(record.isFailure())
            failureCount.incrementAndGet();

        System.out.println("Queue Size : "+queue.size() +" | Failure : "+(failureCount.get()/(1.0*queue.size())));
    }


}
