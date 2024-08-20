package com.company.designpattern.problmes.circuitbreaker;

import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.CircuitBreaker;
import com.company.designpattern.problmes.circuitbreaker.exceptions.CallNotPermittedException;
import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.CircuitBreakerStrategy;
import com.company.designpattern.problmes.circuitbreaker.circuitbreaker.strategies.TimeBasedCircuitBreakerStrategy;

public class Driver {
    public static void main(String[] args) throws CallNotPermittedException {
        CircuitBreakerStrategy<Boolean> timeBasedCircuitBreakerStrategy = new TimeBasedCircuitBreakerStrategy<Boolean>(10000);
        CircuitBreaker<Boolean> apiServiceCommand = new ApiServiceCommand(timeBasedCircuitBreakerStrategy);

        int limit = 500;
        for(int i=0;i<limit;++i) {
            try {
                apiServiceCommand.execute();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            if(i%20==0) {
                try {Thread.sleep(1000);} catch (Exception e) {}
            }
        }
    }
}
