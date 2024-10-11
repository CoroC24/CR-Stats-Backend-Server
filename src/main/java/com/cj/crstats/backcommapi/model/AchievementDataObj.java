package com.cj.crstats.backcommapi.model;

import lombok.Data;

@Data
public class AchievementDataObj {

    private String name;
    private int stars;
    private int value;
    private int target;
    private String info;
    private String completionInfo;
}
