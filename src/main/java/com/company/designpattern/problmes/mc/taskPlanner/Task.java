package com.company.designpattern.problmes.mc.taskPlanner;


import java.util.*;

public class Task {
    private String title;
    private User creator;
    private User assignee;
    private TaskState status;
    private Date dueDate;

    public Task() {
        this.status = new OpenState(TaskEnum.OPEN.name());
    }

    public void setTaskState(TaskState state) {
        this.status = state;
    }

    public TaskState getTaskState() {
        return status;
    }

    public void open() {
        status.open(this);
    }

    public void inProgress() {
        status.inProgress(this);
    }

    public void completed() {
        status.completed(this);
    }

    public void deployed() {
        status.deployed(this);
    }

    public void fixed() {
        status.fixed(this);
    }

    public void testing() {
        status.testing(this);
    }


}
