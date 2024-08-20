package com.company.designpattern.problmes.taskscheduler.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

public interface ITask {
    void execute();
    boolean isRepeatable();
    long getNextTriggerTime();
    Runnable getRunnableTask();

}
