package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenFiveNumbersThenArray() {
        Square arrayExponent = new Square();
        int[] result = arrayExponent.calculate(5);
        assertThat(result, is(new int[] {1, 4, 9, 16, 25}));
    }

    @Test
    public void whenOneNumberThenArray() {
        Square arrayExponent = new Square();
        int[] result = arrayExponent.calculate(1);
        assertThat(result, is(new int[] {1}));
    }


}
