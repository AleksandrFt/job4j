package ru.job4j.lambda;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;


public class FunctionCalculationTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculation function = new FunctionCalculation();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculation function = new FunctionCalculation();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2));
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        FunctionCalculation function = new FunctionCalculation();
        List<Double> result = function.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(Math.log(5), Math.log(6), Math.log(7));
        assertThat(result, is(expected));
    }
}
