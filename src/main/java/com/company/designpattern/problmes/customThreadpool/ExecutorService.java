package com.company.designpattern.problmes.customThreadpool;

import com.company.designpattern.problmes.customThreadpool.exception.ThreadpoolUnavailableException;

public interface ExecutorService {
    void submit(Runnable task) throws ThreadpoolUnavailableException;
    void shutDown();
}
