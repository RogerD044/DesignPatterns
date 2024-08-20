package com.company.designpattern.problmes.mc.newsfeed;
import java.util.*;

public abstract class FeedItem {
    protected int id;
    protected String content;
    protected Date createdAt;
    protected Vote vote;
    protected User createdBy;
    protected List<FeedItem> comments;
    protected int level;

    public FeedItem(User user, String content) {
        this.createdBy = user;
        this.content = content;
        this.createdAt = new Date();
        this.vote = new Vote();
        this.comments = new ArrayList<>();
        this.level = 0;
    }

    public abstract FeedType getFeedItemType();

    public Vote getVote() {
        return vote;
    }

    public List<FeedItem> getComments() {
        return comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public User getCreator() {
        return createdBy;
    }


}
