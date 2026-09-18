package com.dovertraining.assignment4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BracketValidatorTest {
    @Test
    void acceptsCorrectlyBalancedExpressions() {
        assertTrue(BracketValidator.isValid("[{a+b} * (c-d)]"));
        assertTrue(BracketValidator.isValid(""));
        assertTrue(BracketValidator.isValid("()[]{}"));
    }

    @Test
    void rejectsIncorrectlyBalancedExpressions() {
        assertFalse(BracketValidator.isValid("[((a-b} * (c-d)]]]"));
        assertFalse(BracketValidator.isValid("[(])"));
        assertFalse(BracketValidator.isValid("("));
    }
}
