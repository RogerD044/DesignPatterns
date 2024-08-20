package com.company.designpattern.problmes.mc.taskPlanner;

public class Driver {
    public static void main(String[] args) {
        Bug bug = new Bug();
        Feature feature = new Feature();
        Story story = new Story();

        bug.inProgress();
        bug.fixed();

        System.out.println(bug.getTaskState());

        feature.fixed();
        feature.fixed();

    }
}
