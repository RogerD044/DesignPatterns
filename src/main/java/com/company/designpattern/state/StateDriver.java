package com.company.designpattern.state;

interface State {
    void open(Task task);
    void startProgress(Task task);
    void block(Task task);
    void unblock(Task task);
    void requestApproval(Task task);
    void approve(Task task);
    void complete(Task task);
}

class OpenState implements State {
    @Override
    public void open(Task task) {
        System.out.println("Task is already in OPEN state.");
    }

    @Override
    public void startProgress(Task task) {
        System.out.println("Starting task progress...");
        task.setState(new InProgressState());
    }

    @Override
    public void block(Task task) {
        System.out.println("Cannot block an open task. It must be in progress.");
    }

    @Override
    public void unblock(Task task) {
        System.out.println("Task is not blocked.");
    }

    @Override
    public void requestApproval(Task task) {
        System.out.println("Task must be in progress before requesting approval.");
    }

    @Override
    public void approve(Task task) {
        System.out.println("Task must be pending approval to be approved.");
    }

    @Override
    public void complete(Task task) {
        System.out.println("Task must be in progress to complete.");
    }
}

class InProgressState implements State {
    @Override
    public void open(Task task) {
        System.out.println("Task is already started.");
    }

    @Override
    public void startProgress(Task task) {
        System.out.println("Task is already in progress.");
    }

    @Override
    public void block(Task task) {
        System.out.println("Blocking task...");
        task.setState(new BlockedState());
    }

    @Override
    public void unblock(Task task) {
        System.out.println("Task is not blocked.");
    }

    @Override
    public void requestApproval(Task task) {
        System.out.println("Requesting task approval...");
        task.setState(new PendingApprovalState());
    }

    @Override
    public void approve(Task task) {
        System.out.println("Task must be pending approval to be approved.");
    }

    @Override
    public void complete(Task task) {
        System.out.println("Completing task...");
        task.setState(new DoneState());
    }
}

class BlockedState implements State {
    @Override
    public void open(Task task) {
        System.out.println("Task cannot be reopened from blocked state.");
    }

    @Override
    public void startProgress(Task task) {
        System.out.println("Task cannot be started from blocked state.");
    }

    @Override
    public void block(Task task) {
        System.out.println("Task is already blocked.");
    }

    @Override
    public void unblock(Task task) {
        System.out.println("Unblocking task...");
        task.setState(new InProgressState());
    }

    @Override
    public void requestApproval(Task task) {
        System.out.println("Task must be in progress before requesting approval.");
    }

    @Override
    public void approve(Task task) {
        System.out.println("Task must be pending approval to be approved.");
    }

    @Override
    public void complete(Task task) {
        System.out.println("Task must be in progress to complete.");
    }
}

class PendingApprovalState implements State {
    @Override
    public void open(Task task) {
        System.out.println("Task cannot be reopened from pending approval state.");
    }

    @Override
    public void startProgress(Task task) {
        System.out.println("Task is already in progress.");
    }

    @Override
    public void block(Task task) {
        System.out.println("Blocking task...");
        task.setState(new BlockedState());
    }

    @Override
    public void unblock(Task task) {
        System.out.println("Task is not blocked.");
    }

    @Override
    public void requestApproval(Task task) {
        System.out.println("Task is already pending approval.");
    }

    @Override
    public void approve(Task task) {
        System.out.println("Approving task...");
        task.setState(new DoneState());
    }

    @Override
    public void complete(Task task) {
        System.out.println("Task must be approved to complete.");
    }
}
class DoneState implements State {
    @Override
    public void open(Task task) {
        System.out.println("Task is already completed.");
    }

    @Override
    public void startProgress(Task task) {
        System.out.println("Task is already completed.");
    }

    @Override
    public void block(Task task) {
        System.out.println("Task is already completed.");
    }

    @Override
    public void unblock(Task task) {
        System.out.println("Task is already completed.");
    }

    @Override
    public void requestApproval(Task task) {
        System.out.println("Task is already completed.");
    }

    @Override
    public void approve(Task task) {
        System.out.println("Task is already completed.");
    }

    @Override
    public void complete(Task task) {
        System.out.println("Task is already completed.");
    }
}
class Task {
    private State state;

    public Task() {
        state = new OpenState(); // Initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void open() {
        state.open(this);
    }

    public void startProgress() {
        state.startProgress(this);
    }

    public void block() {
        state.block(this);
    }

    public void unblock() {
        state.unblock(this);
    }

    public void requestApproval() {
        state.requestApproval(this);
    }

    public void approve() {
        state.approve(this);
    }

    public void complete() {
        state.complete(this);
    }
}

public class StateDriver {
    public static void main(String[] args) {
        Task task = new Task();

        task.startProgress();  // Starting task progress...
        task.block();          // Blocking task...
        task.unblock();        // Unblocking task...
        task.requestApproval();// Requesting task approval...
        task.approve();        // Approving task...
        task.complete();       // Task is already completed.
    }
}
