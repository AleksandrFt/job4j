package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1d, 1d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoSubOneThenOne() {
        Calculator calc = new Calculator();
        calc.subtraction(2d, 1d);
        double result = calc.getResult();
        double expected = 1d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoMultiTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multipli(2d, 2d);
        double result = calc.getResult();
        double expected = 4d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivSixOnTwoThenThree() {
        Calculator calc = new Calculator();
        calc.division(6d, 2d);
        double result = calc.getResult();
        double expected = 3d;
        assertThat(result, is(expected));
    }
}
