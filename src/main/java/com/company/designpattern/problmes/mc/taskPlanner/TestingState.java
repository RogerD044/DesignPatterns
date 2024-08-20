package com.company.designpattern.problmes.mc.taskPlanner;

public class TestingState extends  TaskState{

    public TestingState(String status) {
        super(status);
    }

    void deployed(Task task) {
        task.setTaskState(new DeployedState(TaskEnum.DEPLOYED.name()));
    }
}
