package com.company.designpattern.problmes.circuitbreaker.circuitbreaker;

import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.model.Record;
import com.company.designpattern.problmes.circuitbreaker.exceptions.CallNotPermittedException;
import com.company.designpattern.problmes.circuitbreaker.exceptions.ServiceUnavailable;
import com.company.designpattern.problmes.circuitbreaker.exceptions.SlowResponseException;

public abstract class CircuitBreaker<T> {

    private CircuitBreakerStrategy<T> circuitBreakerStrategy;

    public CircuitBreaker(CircuitBreakerStrategy<T> circuitBreakerStrategy) {
        this.circuitBreakerStrategy = circuitBreakerStrategy;
    }

    public T execute() throws CallNotPermittedException {
        long startTime = 0;
        boolean isFailure = false;
        T response = null;
        if(circuitBreakerStrategy.allowRequest()) {
            try {
                startTime = System.currentTimeMillis();
                response = run();
                long endTime = System.currentTimeMillis();
                long processTimeInMillis = endTime - startTime;

                if(processTimeInMillis > circuitBreakerStrategy.slowResponseThresholdInMillis)
                    throw new SlowResponseException("Slow Response, Time Taken(ms) is "+processTimeInMillis);

                System.out.println("Call Allowed");

            } catch (Exception e) {
                isFailure = true;
                 e.printStackTrace();
            } finally {
                circuitBreakerStrategy.markRequest(new Record(startTime,isFailure));
            }
        } else {
            throw new CallNotPermittedException("Calls Not Permitted");
        }

        return response;

    }

    protected abstract T run() throws ServiceUnavailable;
    protected abstract T fallback();
}
