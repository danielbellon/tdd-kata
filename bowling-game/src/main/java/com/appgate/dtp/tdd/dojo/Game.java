package com.appgate.dtp.tdd.dojo;

public class Game {

    private int score;
    private int roll;
    private int pinsUps;

    public int score() {
        return score;
    }

    public void roll(int pinsKnockedDown) {
        validatePinsLimitUp(pinsKnockedDown);
        validatePinsLimitDown(pinsKnockedDown);
        if (roll == 0) {
            pinsUps = 10;
            roll++;
        } else if (roll == 1) {
            roll = 0;
            if (pinsKnockedDown > pinsUps) {
                throw new PinsKnockedDownInvalidInSecondRoll();
            }
        }
        score += pinsKnockedDown;
        pinsUps -= pinsKnockedDown;
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

