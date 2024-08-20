package com.company.designpattern.problmes.mc.newsfeed;

public class Driver {

    public static void main(String[] args) throws Exception {

        UserManager userManager = new UserManager();
        NewsFeedManager newsFeedManager = new NewsFeedManager();

        userManager.registerUser("u1");
        userManager.registerUser("u2");

        User u1 = userManager.login("u1");
        User u2 = userManager.login("u2");

        userManager.follow(u1,u2);

        FeedItem p1 = newsFeedManager.post(u1, "1st U1 Post");
        FeedItem p2 = newsFeedManager.post(u2, "1st U2 Post");
        FeedItem p3 = newsFeedManager.post(u2, "2nd U2 Post");
        FeedItem c1 = newsFeedManager.comment(u2,p1,"U2 1st Comment");
        FeedItem c2 = newsFeedManager.comment(u1,p2,"U1 1st Comment");
        FeedItem c3 = newsFeedManager.comment(u1,p3,"U1 2nd Comment");
        FeedItem c4 = newsFeedManager.comment(u1,c3,"Nested 3rd Comment");
        newsFeedManager.upvote(p1,u1);
        newsFeedManager.upvote(p1,u2);
        newsFeedManager.upvote(p3,u2);
        newsFeedManager.upvote(p3,u1);
        newsFeedManager.downvote(c3,u2);



        newsFeedManager.showNewsFeed(u1);



    }
}
