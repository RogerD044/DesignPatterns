package com.company.designpattern.problmes.mc.taskPlanner;

public class InProgressState extends TaskState {

    public InProgressState(String status) {
        super(status);
    }

    public void completed(Task t) {
        if (t instanceof Story)
            t.setTaskState(new CompletedState(TaskEnum.COMPLETED.name()));
        System.out.println("Cannot move to completed");
    }

    void testing(Task task) {
        if(task instanceof Feature)
            task.setTaskState(new TestingState(TaskEnum.TESTING.name()));
        else
            System.out.println("Cannot move to testing");
    }

    void fixed(Task task) {
        if(task instanceof Bug)
            task.setTaskState(new FixedState(TaskEnum.FIXED.name()));
        else
            System.out.println("Cannot move to fixed");
    }
}
