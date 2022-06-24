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
    private int round;

    public int score() {
        return score;
    }

    public void roll(int pinsKnockedDown) {
        validateGameOver();
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

    private void validateGameOver() {
        if (round == 10) {
            if (!isPlusPending()) {
                throw new GameIsOver();
            }
        }
        if (round >= 11) {
            throw new GameIsOver();
        }
    }

    private boolean isPlusPending() {
        return this.pendingPlusBySpire ||
            this.turnPendingPlusByStrikeA != 0 ||
            this.turnPendingPlusByStrikeB != 0;
    }

    private void actionsBySecondRoll(int pinsKnockedDown) {
        validateRemainingPins(pinsKnockedDown);
        setRoll(FIRST_ROLL);
        incrementRound();
        verifyPlusBySpire(pinsKnockedDown);
        assignPlusByStrikeA(pinsKnockedDown);
        assignPlusByStrikeB(pinsKnockedDown);
    }

    private void incrementRound() {
        round++;
    }

    private void actionsByFirstRoll(int pinsKnockedDown) {
        initPinsUp();
        assignPlusByStrikeA(pinsKnockedDown);
        assignPlusByStrikeB(pinsKnockedDown);
        assignPlusBySpire(pinsKnockedDown);
        assignPlusByExtraBall();
        if (pinsKnockedDown == NUMBER_OF_PINS) {
            selectMemoryToStrike();
            setRoll(FIRST_ROLL);
            incrementRound();
        } else {
            setRoll(SECOND_ROLL);
        }
    }

    private void assignPlusByExtraBall() {
        if (round == 10) {
            actualPlus += plusByStrikeA + plusByStrikeB;
            plusByStrikeA = 0;
            plusByStrikeB = 0;
            turnPendingPlusByStrikeA = 0;
            turnPendingPlusByStrikeB = 0;
        }
    }

    private void selectMemoryToStrike() {
        if (turnPendingPlusByStrikeA == 0) {
            turnPendingPlusByStrikeA = 2;
        } else {
            turnPendingPlusByStrikeB = 2;
        }
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

    private void verifyPlusBySpire(int pinsKnockedDown) {
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

