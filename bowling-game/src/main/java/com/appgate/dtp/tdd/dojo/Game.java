package com.appgate.dtp.tdd.dojo;

public class Game {

    public static final int NUMBER_OF_PINS = 10;
    public static final int FIRST_ROLL = 0;
    public static final int SECOND_ROLL = 1;
    private int score;
    private int roll;
    private int pinsUps;
    private boolean pendingPlusBySpire = false;
    private int turnPendingPlusByStrikeA;
    private int turnPendingPlusByStrikeB;
    private int plusByStrikeA;
    private int plusByStrikeB;
    private int actualPlus;

    public int score() {
        return score;
    }

    public void roll(int pinsKnockedDown) {
        validatePinsLimitUp(pinsKnockedDown);
        validatePinsLimitDown(pinsKnockedDown);
        if (isRoll(FIRST_ROLL)) {
            actionsByFirstRoll(pinsKnockedDown);
        } else if (isRoll(SECOND_ROLL)) {
            actionsBySecondRoll(pinsKnockedDown);
        }
        score += pinsKnockedDown + actualPlus;
        pinsUps -= pinsKnockedDown;
        actualPlus = 0;
    }

    private void actionsBySecondRoll(int pinsKnockedDown) {
        setRoll(FIRST_ROLL);
        validateRemainingPins(pinsKnockedDown);
        validatePlusBySpire(pinsKnockedDown);
        assignPlusByStrikeA(pinsKnockedDown);
    }

    private void actionsByFirstRoll(int pinsKnockedDown) {
        initPinsUp();
        assignPlusByStrikeA(pinsKnockedDown);
        assignPlusByStrikeB(pinsKnockedDown);
        if (pinsKnockedDown == NUMBER_OF_PINS) {
            if (turnPendingPlusByStrikeA == 0) {
                turnPendingPlusByStrikeA = 2;
            } else {
                turnPendingPlusByStrikeB = 2;
            }
            setRoll(FIRST_ROLL);
        } else {
            setRoll(SECOND_ROLL);
        }
        assignPlusBySpire(pinsKnockedDown);
    }

    private void assignPlusByStrikeB(int pinsKnockedDown) {
        if (turnPendingPlusByStrikeB > 0) {
            this.plusByStrikeB += pinsKnockedDown;
            turnPendingPlusByStrikeB--;
            if (turnPendingPlusByStrikeB == 0) {
                actualPlus = plusByStrikeB;
                plusByStrikeB = 0;
            }
        }
    }

    private void assignPlusByStrikeA(int pinsKnockedDown) {
        if (turnPendingPlusByStrikeA > 0) {
            this.plusByStrikeA += pinsKnockedDown;
            turnPendingPlusByStrikeA--;
            if (turnPendingPlusByStrikeA == 0) {
                actualPlus = plusByStrikeA;
                plusByStrikeA = 0;
            }
        }
    }

    private void validatePlusBySpire(int pinsKnockedDown) {
        pendingPlusBySpire = pinsUps == pinsKnockedDown;
    }

    private void assignPlusBySpire(int pinsKnockedDown) {
        if (pendingPlusBySpire) {
            actualPlus += pinsKnockedDown;
        }
    }

    private void setRoll(int newRoll) {
        roll = newRoll;
    }

    private boolean isRoll(int i) {
        return roll == i;
    }

    private void initPinsUp() {
        pinsUps = NUMBER_OF_PINS;
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
        if (pinsKnockedDown > NUMBER_OF_PINS) {
            throw new IllegalArgumentException();
        }
    }
}

