package com.appgate.dtp.tdd.dojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Bowling Game")
class GameTest {

    @Test
    @DisplayName("readable test name")
    void shouldDoSomething() {

    }

    @Test
    @Order(1)
    @DisplayName("Initial condition")
    void shouldReturnZeroWhenGameStarted(){
//        Given
//        When
//        Then
        fail();
    }
}
