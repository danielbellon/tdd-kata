package com.appgate.dtp.tdd.dojo;

public class Game {

    private int score;

    public int score() {
        return score;
    }

    public void roll(int pinsKnockedDown) {
        validatePinsLimitUp(pinsKnockedDown);
        validatePinsLimitDown(pinsKnockedDown);
    }

    private void validatePinsLimitDown(int pinsKnockedDown) {
        if (pinsKnockedDown < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePinsLimitUp(int pinsKnockedDown) {
        if (pinsKnockedDown > 10) {
            throw new IllegalArgumentException();
        }
    }
}

