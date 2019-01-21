package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {

    @Test
    public void whenArrayIncludeNumber() {
        int[] array = {4, 24, 0, 743, 2, 8, 34};
        int number = 2;
        FindLoop search = new FindLoop();
        int result = search.indexOf(array, number);
        assertThat(result, is(4));
    }
}
