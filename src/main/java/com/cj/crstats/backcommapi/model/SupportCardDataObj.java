package com.cj.crstats.backcommapi.model;

import lombok.Data;

@Data

public class SupportCardDataObj {

    private String name;
    private int id;
    private int level;
    private int maxLevel;
    private String rarity;
    private int count;
    private IconUrlsDataObj iconUrls;
}
