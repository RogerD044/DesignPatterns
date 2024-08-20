package com.company.designpattern.problmes.mc.newsfeed;

public class Post extends FeedItem{

    public Post(User user, String content) {
        super(user,content);
    }

    public FeedType getFeedItemType() {
        return FeedType.POST;
    }
}
