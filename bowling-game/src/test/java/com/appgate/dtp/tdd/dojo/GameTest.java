package com.appgate.dtp.tdd.dojo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("Bowling Game")
class GameTest {

    @Test
    @DisplayName("readable test name")
    void shouldDoSomething() {

    }

    /**
     * Initial Condition
     */
    @Test
    @Order(1)
    @DisplayName("Initial condition")
    void shouldReturnZeroWhenGameStarted() {
//        Given
        Game game = new Game();
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
    void shouldReturnErrorWhenNumberOfPinsKnockedDownIsMoreThanLimit(){
        Game game = new Game();

//        When
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.roll(11);
        });
    }
    /**
     *
     */
}
