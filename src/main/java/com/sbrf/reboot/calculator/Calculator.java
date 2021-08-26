package com.sbrf.reboot.calculator;

/**
 * The class <i>Calculator</i> contains several methods for basic numeric operations.
 */
public class Calculator {

    private Calculator() {
    }

    /**
     * Addition of two {@code int} values.
     *
     * @param a a first operand
     * @param b a second operand
     * @return the value {@code a} + {@code b}
     */
    public static int getAddition(int a, int b) {
        return a + b;
    }

    /**
     * Subtraction of two {@code int} values.
     *
     * @param a a first operand
     * @param b a second operand
     * @return the value {@code a} - {@code b}
     */
    public static int getSubtraction(int a, int b) {
        return a - b;
    }

    /**
     * Multiplication of two {@code int} values.
     *
     * @param a a first operand
     * @param b a second operand
     * @return the value {@code a} * {@code b}
     */
    public static int getMultiplication(int a, int b) {
        return a * b;
    }

    /**
     * Division of two {@code int} values.
     *
     * @param a a first operand.
     * @param b a second operand.
     * @return the value {@code a} / {@code b}.
     */
    public static int getDivision(int a, int b) {
        return a / b;
    }

    /**
     * Remainder of division.
     *
     * @param a a first operand
     * @param b a second operand
     * @return the value {@code a} % {@code b}
     */
    public static int getRemainderOfDivision(int a, int b) {
        return a % b;
    }

    /**
     * Raising the first argument to the power of the second argument.
     *
     * @param a a base
     * @param b a power
     * @return result {@code a}<sup>{@code b}</sup>
     */
    public static double getPow(double a, double b) {
        return Math.pow(a, b);
    }

    /**
     * The square root of {@code double} value.
     * Throwing {@link IllegalArgumentException} if value less than zero.
     *
     * @param a a positive value
     * @return the square root of {@code a}
     * @throws IllegalArgumentException if value less than zero
     */
    public static double getSqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(a);
    }
}