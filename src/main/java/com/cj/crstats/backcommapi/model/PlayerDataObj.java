package com.cj.crstats.backcommapi.model;


import lombok.Data;

import java.util.List;

@Data
public class PlayerDataObj {

    private String tag;
    private String name;
    private int expLevel;
    private int trophies;
    private int bestTrophies;
    private int wins;
    private int losses;
    private int battleCount;
    private int threeCrownWins;
    private int challengeCardsWon;
    private int challengeMaxWins;
    private int tournamentCardsWon;
    private int tournamentBattleCount;
    private String role;
    private int donations;
    private int donationsReceived;
    private int totalDonations;
    private int warDayWins;
    private int clanCardsCollected;
    private ClanDataObj clan;
    private ArenaDataObj arena;
    private List<BadgeDataObj> badges;
    private List<AchievementDataObj> achievements;
    private List<CardDataObj> cards;
    private List<SupportCardDataObj> supportCards;
    private List<CardDataObj> currentDeck;

}
