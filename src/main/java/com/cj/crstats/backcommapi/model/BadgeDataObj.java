package com.cj.crstats.backcommapi.model;

import lombok.Data;

@Data
public class BadgeDataObj {

    private String name;
    private int level;
    private int maxLevel;
    private int progress;
    private int target;
    private IconUrlsDataObj iconUrls;
}
