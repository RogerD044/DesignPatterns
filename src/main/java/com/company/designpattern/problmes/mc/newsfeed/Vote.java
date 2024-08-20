package com.company.designpattern.problmes.mc.newsfeed;

public class Vote {
    private int upvote;
    private int downvote;

    public Vote(){
        this.upvote = 0;
        this.downvote = 0;
    }

    public synchronized void upVote() {
        upvote++;
    }

    public synchronized void downVote() {
        downvote++;
    }

    public int getUpvotes() {
        return upvote;
    }

    public int getDownvotes() {
        return downvote;
    }


}
