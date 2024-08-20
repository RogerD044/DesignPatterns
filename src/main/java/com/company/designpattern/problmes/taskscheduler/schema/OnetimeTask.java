package com.company.designpattern.problmes.taskscheduler.schema;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OnetimeTask implements ITask{
    private Runnable runnable;
    private long nextTriggerTime;

    @Override
    public void execute() {
        runnable.run();
    }

    public boolean isRepeatable() {
        return false;
    }

    @Override
    public long getNextTriggerTime() {
        return nextTriggerTime;
    }

    @Override
    public Runnable getRunnableTask() {
        return runnable;
    }
}
