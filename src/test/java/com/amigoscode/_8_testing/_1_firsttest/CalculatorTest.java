package com.amigoscode._8_testing._1_firsttest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise: Your First Unit Tests
 *
 * In this exercise you will write your first JUnit 5 tests for the Calculator class.
 * Complete each TODO to practice basic assertions and test lifecycle annotations.
 */

class CalculatorTest {
    private Calculator underTest = new Calculator();

    // TODO: 1 - Declare a Calculator field and use @BeforeEach to create a fresh
    //  Calculator instance before each test. This ensures tests are independent.
    //  Hint: Write a setUp() method annotated with @BeforeEach that assigns
    //  a new Calculator() to your field.
    @BeforeEach
    void setUp(){
        underTest = new Calculator();
    }


    // TODO: 2 - Write a test for the add method using assertEquals.
    //  Annotate it with @Test and @DisplayName("2 + 3 should equal 5").
    //  Call calculator.add(2, 3) and assert the result equals 5.

    @Test
    @DisplayName("2 + 3 should equal 5")
    void canAdd(){

        var actual = underTest.add(2,3);
        var expected = 5;
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 3 - Write a test for the subtract method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.subtract(10, 4) equals 6.

    @Test
    @DisplayName("10 - 4 should equal 6")
    void canSubtract(){
        var actual = underTest.subtract(10,4);
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 4 - Write a test for the multiply method.
    //  Annotate with @Test and @DisplayName.
    //  Test that calculator.multiply(3, 7) equals 21.

    @Test
    @DisplayName("3 * 7 should equal 21")
    void canMultiply(){
        var actual = underTest.multiply(3,7);
        int expected = 21;
        assertThat(actual).isEqualTo(expected);
    }


    // TODO: 5 - Write a test that verifies dividing by zero throws ArithmeticException.
    //  Use assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0)).
    //  Add a @DisplayName annotation.
    @Test
    @DisplayName("Dividing by zero throws ArithmeticException")
    void dividingByZeroThrowsArithmeticException(){
        assertThatThrownBy(() -> underTest.divide(10,0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("Cannot divide by zero");
    }


    // TODO: 6 - Write a test using assertNotEquals.
    //  Verify that calculator.add(2, 2) is NOT equal to 5.
    //  Add a @DisplayName annotation.

    @Test
    @DisplayName("2 + 2 is not equal to 5")
    void twoPlusTwoIsNotFive(){
        var actual = underTest.add(2,2);
        int unexpected = 5;
        assertNotEquals(unexpected,actual);
    }


    // TODO: 7 - Add @DisplayName annotations to ALL of your tests above (if not done already).
    //  Make the display names descriptive, e.g., "Adding 2 and 3 should return 5".
    //  Then write one more test: verify that calculator.divide(10, 2) equals 5.

    @Test
    @DisplayName("10 divide 2 is 5")
    void canDivide(){

        var actual = underTest.divide(10,2);
        int expected = 5;
        assertThat(actual).isEqualTo(expected);
    }

}
