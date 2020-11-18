package com.vysh.blackjack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Player {

    private String playerId;
    private String name;
    private int seatNum;
    private int chips;
    private List<Hand> hands;
    private int handsPlayed;
    private Integer nextBet;
    private boolean isActive;

    public Player() {
    }

    public Player(String name, int seatNum) {
        playerId = UUID.randomUUID().toString();
        this.name = name;
        this.seatNum = seatNum;
        chips =  1000;
        hands = new ArrayList<>();
        handsPlayed = 0;
        isActive = true;
    }

    @JsonIgnore
    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public List<Hand> getHands() {
        return hands;
    }

    public void setHands(List<Hand> hands) {
        this.hands = hands;
    }

    public void addHand(Hand hand) {
        hands.add(hand);
    }

    public void clearHands() {
        hands = new ArrayList<>();
    }

    public void decrementChipCount(int betAmount) {
        chips -= betAmount;
    }

    public void incrementChipCount(int amountWon) {
        chips += amountWon;
    }

    public int getHandsPlayed() {
        return handsPlayed;
    }

    public void setHandsPlayed(int handsPlayed) {
        this.handsPlayed = handsPlayed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void incrementHandsPlayed() {
        handsPlayed++;
    }

    public void removeOldHands() {
        hands.clear();
    }

    @JsonIgnore
    public Integer getNextBet() {
        return nextBet;
    }

    public void setNextBet(Integer nextBet) {
        this.nextBet = nextBet;
    }

    public boolean isBetInForNextRound() {
        return nextBet != null;
    }

    public void moveBetToNewHand() {
        chips -= nextBet;
        hands.add(new Hand(nextBet));
        nextBet = null;
    }

    public void toggleIsActive() {
        isActive = !isActive;
    }

}



