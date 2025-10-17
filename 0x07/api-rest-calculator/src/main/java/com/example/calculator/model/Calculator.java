package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Number 1 and Number 2 are required.");
        }
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Number 1 and Number 2 are required.");
        }
        return number1 - number2;
    }

    public Double divide(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Number 1 and Number 2 are required.");
        }
        if (number2 == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        if (factorial == null) {
            throw new NullPointerException("Number is required.");
        }
        if (factorial < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        int result = 1;
        for (int i = 2; i <= factorial; i++) {
            result *= i;
        }
        return result;
    }

    // e.g., 5 -> 101  (as Integer 101)
    public Integer integerToBinary(Integer integer) {
        if (integer == null) {
            throw new NullPointerException("Number is required.");
        }
        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    // e.g., 170 -> "AA"
    public String integerToHexadecimal(Integer integer) {
        if (integer == null) {
            throw new NullPointerException("Number is required.");
        }
        return Integer.toHexString(integer).toUpperCase();
    }

    // absolute number of days between the two dates
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new NullPointerException("Dates are required.");
        }
        long days = ChronoUnit.DAYS.between(date1, date2);
        return (int) Math.abs(days);
    }
}
