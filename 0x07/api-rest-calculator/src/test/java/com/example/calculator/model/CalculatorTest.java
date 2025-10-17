package com.example.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void sumTest() {
        assertEquals(5.0, calc.sum(2.0, 3.0));
    }

    @Test
    public void numbersNullSumTest() {
        NullPointerException ex = assertThrows(NullPointerException.class, () -> calc.sum(null, 2.0));
        assertEquals("Number 1 and Number 2 are required.", ex.getMessage());
        ex = assertThrows(NullPointerException.class, () -> calc.sum(2.0, null));
        assertEquals("Number 1 and Number 2 are required.", ex.getMessage());
    }

    @Test
    void subTest() {
        assertEquals(4.0, calc.sub(7.0, 3.0));
    }

    @Test
    void divideTest() {
        assertEquals(2.5, calc.divide(5.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calc.divide(5.0, 0.0));
        assertEquals("Division by zero is not allowed.", ex.getMessage());
    }

    @Test
    void factorialTest() {
        assertEquals(120, calc.factorial(5));
        assertEquals(1, calc.factorial(0));
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(1, calc.integerToBinary(1));
        assertEquals(101, calc.integerToBinary(5));
        assertEquals(10100, calc.integerToBinary(20));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("1", calc.integerToHexadecimal(1));
        assertEquals("37", calc.integerToHexadecimal(55));
        assertEquals("AA", calc.integerToHexadecimal(170));
    }

    @Test
    void calculeDayBetweenDateTest() {
        int days = calc.calculeDayBetweenDate(
                LocalDate.of(2020, 3, 15),
                LocalDate.of(2020, 3, 29)
        );
        assertEquals(14, days);
    }
}
