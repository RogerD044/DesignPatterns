package com.company.designpattern.problmes.taskscheduler;

import com.company.designpattern.problmes.callback.Task;

public interface ITaskScheduler {
    void schedule(Runnable task, long triggerAt);
    void scheduleAtFixedInterval(Runnable task, long interval);
    void shutDown();
}
