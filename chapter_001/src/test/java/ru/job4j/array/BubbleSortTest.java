package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenNotAortedArrayThen() {
        BubbleSort sortArray = new BubbleSort();
        int[] array = {7, 2, 9, 4, 1, 0, 3, 6, 8, 5};
        int[] result = sortArray.sort(array);
        int[] expect = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(result, is(expect));
    }

}
