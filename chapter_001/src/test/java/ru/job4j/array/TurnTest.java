package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenArrayContainsEvenElements() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Turn sequnce = new Turn();
        int[] expect = {8, 7, 6, 5, 4, 3, 2, 1};
        int[] result = sequnce.back(array);
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayContainsOddElements() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Turn sequnce = new Turn();
        int[] expect = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] result = sequnce.back(array);
        assertThat(result, is(expect));
    }

}
