package com.company.designpattern.problmes.circuitbreaker;

import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.CircuitBreaker;
import com.company.designpattern.problmes.circuitbreaker.exceptions.ServiceUnavailable;
import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.CircuitBreakerStrategy;

import java.util.Random;

public class ApiServiceCommand extends CircuitBreaker<Boolean> {
    public ApiServiceCommand(CircuitBreakerStrategy<Boolean> circuitBreakerStrategy) {
        super(circuitBreakerStrategy);
    }

    @Override
    protected Boolean run() throws ServiceUnavailable {
        Random random = new Random();

        try { Thread.sleep(Math.abs(random.nextInt()%300)); }
        catch (Exception e) { e.printStackTrace(); }

        if(random.nextInt()%3==0) {
             throw new ServiceUnavailable("Service is Unavailable");
        }

        return true;
    }

    @Override
    protected Boolean fallback() {
        return null;
    }
}
