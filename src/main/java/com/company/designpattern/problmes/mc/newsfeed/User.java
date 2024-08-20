package com.company.designpattern.problmes.mc.newsfeed;

import java.util.*;

public class User {
    private String name;
    private List<FeedItem> posts;
    private boolean isLoggedIn;
    private Set<User> followers;

    public User(String name) {
        this.name = name;
        this.posts = new ArrayList<>();
        this.isLoggedIn = false;
        this.followers = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void login() {
        isLoggedIn = true;
    }

    public void logout() {
        isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void addPost(FeedItem post) {
        posts.add(post);
    }

    public void follow(User user) {
        followers.add(user);
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public List<FeedItem> getPosts() {
        return posts;
    }

}
