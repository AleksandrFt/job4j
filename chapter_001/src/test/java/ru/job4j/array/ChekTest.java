package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChekTest {
    @Test
    public void whenArrayContainsTrueAndFalseThanFalse() {
        Chek compare = new Chek();
        boolean[] array = {false, false, true};
        boolean result = compare.mono(array);
        assertThat(result, is(false));
    }
    @Test
    public void whenArrayContainsAllTrueThanTrue() {
        Chek compare = new Chek();
        boolean[] array = {true, true, true};
        boolean result = compare.mono(array);
        assertThat(result, is(true));
    }
    @Test
    public void whenArrayContainsAllFalseThanTrue() {
        Chek compare = new Chek();
        boolean[] array = {false, false, false};
        boolean result = compare.mono(array);
        assertThat(result, is(false));
    }

}
