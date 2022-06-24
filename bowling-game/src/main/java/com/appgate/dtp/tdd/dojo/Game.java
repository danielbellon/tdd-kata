package com.appgate.dtp.tdd.dojo;

public class Game {

    private int score;

    public int score() {
        return score;
    }

    public void roll(int pinsKnockedDown) {
        if (pinsKnockedDown > 10) {
            throw new IllegalArgumentException();
        }
    }
}

