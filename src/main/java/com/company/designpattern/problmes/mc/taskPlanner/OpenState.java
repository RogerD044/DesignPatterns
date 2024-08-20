package com.company.designpattern.problmes.mc.taskPlanner;

public class OpenState extends  TaskState{

    public OpenState(String staus) {
        super(staus);
    }

    @Override
    public void inProgress(Task t) {
        t.setTaskState(new InProgressState(TaskEnum.IN_PROGRESS.name()));
    }
}
