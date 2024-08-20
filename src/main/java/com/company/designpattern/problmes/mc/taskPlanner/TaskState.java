package com.company.designpattern.problmes.mc.taskPlanner;

public class TaskState {
    public String status;
    public TaskState(String status) {
        this.status = status;
    }

    public void open(Task t) {
        System.out.println("Cannot move from "+ this.status +"to Open");
    }

    public void inProgress(Task t) {
        System.out.println("Cannot move from "+ this.status +"to inProgress");
    }

    public void completed(Task t) {
        System.out.println("Cannot move from "+ this.status +"to completed");
    }

    void testing(Task task) {
        System.out.println("Cannot move from "+ this.status +"to testing");
    }

    void deployed(Task task) {
        System.out.println("Cannot move from "+ this.status +"to deployed");
    }
    void fixed(Task task) {
        System.out.println("Cannot move from "+ this.status +"to fixed");
    }

}
