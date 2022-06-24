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
    /**
     *
     */
}
