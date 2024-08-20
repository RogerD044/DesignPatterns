package com.company.designpattern.problmes.mc.newsfeed.chain;

import com.company.designpattern.problmes.mc.newsfeed.FeedItem;

import java.util.Comparator;

public class CommentSizeComparator implements Comparator<FeedItem> {

    @Override
    public int compare(FeedItem o1, FeedItem o2) {
        int c1 = o1.getComments().size();
        int c2 = o2.getComments().size();
        return Integer.compare(c1, c2);
    }
}
