package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {

    @Test
    public void whenNumberFiveThenFactorialOneHundredTwenty() {
        Factorial multiply  = new Factorial();
        int result = multiply.calc(5);
        assertThat(result, is(120));
    }

    @Test
    public void whenNumberZeroThenFactorialOne() {
        Factorial multiply  = new Factorial();
        int result = multiply.calc(0);
        assertThat(result, is(1));
    }

}
