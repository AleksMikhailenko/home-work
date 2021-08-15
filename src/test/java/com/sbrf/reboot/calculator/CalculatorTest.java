package com.sbrf.reboot.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for Calculator")
class CalculatorTest {

    private static final double DELTA = 1e-10;

    @Test
    @DisplayName("Addition of two values")
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    @DisplayName("Subtraction of two values")
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    @DisplayName("Multiplication of two values")
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    @DisplayName("Division of two values")
    void getDivision() {
        assertEquals(3, Calculator.getDivision(9, 3));
    }

    @Test
    @DisplayName("Counting of class methods")
    void classHasSevenMethods(){
        assertEquals(7,Calculator.class.getMethods().length-Object.class.getMethods().length);
    }

    @Test
    @DisplayName("Remainder of division")
    void getRemainderOfDivision() {
        assertEquals(1, Calculator.getRemainderOfDivision(10, 3));
    }

    @Test
    @DisplayName("Raising the first argument to the power of the second argument")
    void getPow() {
        assertEquals(64, Calculator.getPow(2, 6), DELTA);
    }

    @Test
    @DisplayName("The square root of value")
    void getSqrt() {
        assertEquals(5, Calculator.getSqrt(25), DELTA);
    }

    @Test
    @DisplayName("The square root of illegal argument")
    void shouldThrowsIAExceptionFromGetSqrt() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.getSqrt(-5));
    }
}