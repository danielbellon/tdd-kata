package com.appgate.dtp.tdd.dojo;

import org.junit.jupiter.api.*;

@DisplayName("Bowling Game")
class GameTest {
    Game game;

    @Test
    @DisplayName("readable test name")
    void shouldDoSomething() {

    }
    @BeforeEach
    void init(){
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
    void shouldReturnErrorWhenNumberOfPinsKnockedDownIsMoreThanLimit(){
//        When
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.roll(11);
        });
    }
    @Test
    @Order(3)
    @DisplayName("should return error when the number of pins knocked down is under limit")
    void shouldReturnErrorWhenNumberOfPinsKnockedDownIsUnderLimit(){
//        When
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            game.roll(-1);
        });
    }
    /**
     *
     */
}
