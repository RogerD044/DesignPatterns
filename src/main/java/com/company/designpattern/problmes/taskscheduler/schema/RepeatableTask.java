package com.company.designpattern.problmes.taskscheduler.schema;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RepeatableTask implements ITask{
    private Runnable runnable;
    private long nextTriggerTime;
    private long interval;

    @Override
    public void execute() {
        runnable.run();
    }

    public boolean isRepeatable() {
        return true;
    }

    public long getNextTriggerTime() {
        return nextTriggerTime;
    }

    public Runnable getRunnableTask() {
        return runnable;
    }
}
