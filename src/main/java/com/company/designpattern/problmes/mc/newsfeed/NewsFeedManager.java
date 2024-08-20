package com.company.designpattern.problmes.mc.newsfeed;

import com.company.designpattern.problmes.mc.newsfeed.chain.CommentSizeComparator;
import com.company.designpattern.problmes.mc.newsfeed.chain.CreatedAtComparator;
import com.company.designpattern.problmes.mc.newsfeed.chain.ScoreComparator;

import java.util.*;
public class NewsFeedManager {
    private List<FeedItem> feedItemList;

    public FeedItem post(User user, String content) throws Exception{
        if(!user.isLoggedIn())
            throw new Exception("User isnt logged in");

        FeedItem post = new Post(user,content);
        addPostUtil(user,post);
        return post;
    }

    // Critical Section
    private synchronized void addPostUtil(User user, FeedItem post) {
        user.addPost(post);
    }

    public void upvote(FeedItem feedItem, User user) {
        if(user.isLoggedIn())
            feedItem.getVote().upVote();
    }

    public void downvote(FeedItem feedItem, User user) {
        if(user.isLoggedIn())
            feedItem.getVote().downVote();
    }

    public FeedItem comment(User user,FeedItem feedItem, String content) {
        FeedItem comment = new Comment(user,content);
        comment.setLevel(feedItem.getLevel()+1);

        commentUtil(feedItem,comment);

        return comment;
    }

    private synchronized void commentUtil(FeedItem feedItem, FeedItem comment) {
        feedItem.getComments().add(comment);
    }

    public void showNewsFeed(User user) throws Exception{
        if(!user.isLoggedIn())
            throw new Exception("User isnt logged in");

        List<FeedItem> feeds = new ArrayList<>(user.getPosts());
        // Followers Posts
        for(User f1 : user.getFollowers()) {
            feeds.addAll(f1.getPosts());
        }

        Comparator<FeedItem> comparatorChain = new ScoreComparator()
                .thenComparing(new CommentSizeComparator())
                .thenComparing(new CreatedAtComparator());

        feeds.sort(comparatorChain);

        for (FeedItem feedItem : feeds) {
            printFeed(feedItem,0);
        }
    }

    private void printFeed(FeedItem feedItem, int level) {
        for(int i=0;i<level;++i) {
            System.out.print("\t");
        }

        System.out.println("["+feedItem.getCreatedAt()+"] "+feedItem.getCreator().getName()+" | "+feedItem.getContent()+" | U"+feedItem.getVote().getUpvotes()+" | D"+feedItem.getVote().getDownvotes());

        for(FeedItem feedItem1 : feedItem.getComments()) {
            printFeed(feedItem1,level+1);
        }
    }

}