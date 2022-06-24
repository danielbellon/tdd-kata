package com.appgate.dtp.tdd.dojo;

public class Game {

    private int score;
    private int roll;
    private int pinsUps;
    private boolean pendingPlusBySpire = false;
    private int actualPlus;

    public int score() {
        return score;
    }

    public void roll(int pinsKnockedDown) {
        validatePinsLimitUp(pinsKnockedDown);
        validatePinsLimitDown(pinsKnockedDown);
        if (isRoll(0)) {
            initPinsUp();
            setRoll(1);
            if (pendingPlusBySpire) {
                actualPlus += pinsKnockedDown;
            }
        } else if (isRoll(1)) {
            setRoll(0);
            validateRemainingPins(pinsKnockedDown);
            pendingPlusBySpire = pinsUps == pinsKnockedDown;
        }
        score += pinsKnockedDown + actualPlus;
        pinsUps -= pinsKnockedDown;
    }

    private void setRoll(int newRoll) {
        roll = newRoll;
    }

    private boolean isRoll(int i) {
        return roll == i;
    }

    private void initPinsUp() {
        pinsUps = 10;
    }

    private void validateRemainingPins(int pinsKnockedDown) {
        if (pinsKnockedDown > pinsUps) {
            throw new PinsKnockedDownInvalidInSecondRoll();
        }
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

