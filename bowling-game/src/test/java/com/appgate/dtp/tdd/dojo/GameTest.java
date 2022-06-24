package com.appgate.dtp.tdd.dojo;

import org.junit.jupiter.api.*;

@DisplayName("Bowling Game")
class GameTest {
    Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    /**
     * Initial Condition
     */
    @Test
    @Order(1)
    @DisplayName("Initial condition")
    void shouldReturnZeroWhenGameStarted() {
//        Given
//        When
        int score = game.score();
//        Then
        Assertions.assertEquals(0, score);
    }

    /**
     * Invalid inputs
     */
    @Test
    @Order(2)
    @DisplayName("should return error when the number of pins knocked down is more than limit")
    void shouldReturnErrorWhenNumberOfPinsKnockedDownIsMoreThanLimit() {
//        When
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.roll(11);
        });
    }

    @Test
    @Order(3)
    @DisplayName("should return error when the number of pins knocked down is under limit")
    void shouldReturnErrorWhenNumberOfPinsKnockedDownIsUnderLimit() {
//        When
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.roll(-1);
        });
    }

    /**
     * functionality
     */
    @Test
    @Order(4)
    @DisplayName("should return score when roll a valid pins knocked down")
    void shouldReturnScoreWhenRollAndPinsKnockedDownIsValid() {
//        When
        game.roll(5);
        Assertions.assertEquals(5, game.score());
    }

    @Test
    @Order(5)
    @DisplayName("should return error when pins knocked down is invalid in roll 2")
    void shouldReturnErrorWhenPinsKnockedDownIsInvalidInRoll2() {
//        When
        game.roll(5);
        Assertions.assertThrows(PinsKnockedDownInvalidInSecondRoll.class,
            () -> {
                game.roll(8);
            });
    }

    @Test
    @Order(6)
    @DisplayName("should return score when pins knocked down is valid in roll 2")
    void shouldReturnScoreWhenPinsKnockedDownIsValidInRoll2() {
//        When
        game.roll(5);
        game.roll(3);

        Assertions.assertEquals(8, game.score());
    }

    @Test
    @Order(7)
    @DisplayName("should return score without plus when pins knocked down is valid in roll 3")
    void shouldReturnScoreWhenPinsKnockedDownIsValidInRoll3() {
//        When
        game.roll(5);
        game.roll(3);
        game.roll(3);

        Assertions.assertEquals(11, game.score());
    }

    @Test
    @Order(8)
    @DisplayName("should return score with plus by spare in roll 2")
    void shouldReturnScoreWithPlusBySpareInRoll2() {
//        When
        game.roll(5);
        game.roll(5);
        game.roll(3);

        int scoreExpected = 5 + 5 + 3 + 3;
        Assertions.assertEquals(scoreExpected, game.score());
    }

    @Test
    @Order(9)
    @DisplayName("should return score with plus by spare in roll 2 and not plus in roll 4")
    void shouldReturnScoreWithPlusBySpareInRoll2AndNotPlusInRoll4() {
//        When
        game.roll(5);
        game.roll(5);
        game.roll(3);
        game.roll(3);

        int scoreExpected = 5 + 5 + (3 + 3) + 3;
        Assertions.assertEquals(scoreExpected, game.score());
    }

    @Test
    @Order(10)
    @DisplayName("should return score with plus by strike in roll 1 and not plus in next 2 rolls")
    void shouldReturnScoreWithPlusByStrikeInRollOneAndNotPlusInNextTwoRolls() {
//        When
        game.roll(10);
        game.roll(5);
        game.roll(3);

        int scoreExpected = 10 + 5 + 3 + (5 + 3);
        Assertions.assertEquals(scoreExpected, game.score());
    }

    @Test
    @Order(11)
    @DisplayName("should return score by 3 strike in row")
    void shouldReturnScoreBy3StrikeInRow() {
//        When
        game.roll(10);
        game.roll(10);
        game.roll(10);

        int scoreExpected = 10 + 10 + 10 + (10 + 10);
        Assertions.assertEquals(scoreExpected, game.score());
    }

    @Test
    @Order(12)
    @DisplayName("should return score by 2 strike in row with + 2 roll")
    void shouldReturnScoreBy2StrikeInRowAnd2Roll() {
//        When
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(4);

        int scoreExpected = 10 + 10 + 5 + (10 + 5) + 4 + (5 + 4);
        Assertions.assertEquals(scoreExpected, game.score());
    }

    @Test
    @Order(13)
    @DisplayName("should return error when intent 1 roll after 10 simple frames")
    void shouldReturnErrorWhenIntentOneRollAfterTenSimpleFrames() {
//        When
        for (int i = 0; i < 20; i++) {
            game.roll(4);
        }
        Assertions.assertThrows(GameIsOver.class,
            () -> {
                game.roll(4);
            });

        int scoreExpected = 80;
        Assertions.assertEquals(scoreExpected, game.score());
    }

    @Test
    @Order(14)
    @DisplayName("should return score when intent 1 roll after 10 frames with extra ball by spire")
    void shouldReturnScoreWhenIntentOneRollAfterTenFramesWithExtraBallBySpire() {
//        When
        for (int i = 0; i < 19; i++) {
            game.roll(4);
        }
        game.roll(6);

        game.roll(7);

        int scoreExpected = 19 * 4 + 6 + 7 + (7);
        Assertions.assertEquals(scoreExpected, game.score());
    }
}
