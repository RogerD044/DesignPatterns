package com.company.designpattern.problmes.mc.newsfeed.chain;

import com.company.designpattern.problmes.mc.newsfeed.FeedItem;

import java.util.Comparator;

public class CreatedAtComparator implements Comparator<FeedItem> {

    @Override
    public int compare(FeedItem o1, FeedItem o2) {
        if(o1.getCreatedAt().before(o2.getCreatedAt()))
            return -1;
        else if(o1.getCreatedAt().after(o2.getCreatedAt()))
            return 1;
        return 0;
    }
}
