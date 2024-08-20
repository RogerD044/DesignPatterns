package com.company.designpattern.problmes.mc.newsfeed.chain;

import com.company.designpattern.problmes.mc.newsfeed.FeedItem;

import java.util.Comparator;

public class ScoreComparator implements Comparator<FeedItem> {

    @Override
    public int compare(FeedItem o1, FeedItem o2) {
        int score1 = o1.getVote().getUpvotes() - o1.getVote().getDownvotes();
        int score2 = o2.getVote().getUpvotes() - o2.getVote().getDownvotes();
        return Integer.compare(score1, score2);
    }
}
