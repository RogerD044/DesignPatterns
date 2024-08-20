package com.company.designpattern.problmes.mc.newsfeed;

public class Comment extends FeedItem {

    public Comment(User user, String content) {
        super(user,content);
    }

    public FeedType getFeedItemType() {
        return FeedType.COMMENT;
    }
}
