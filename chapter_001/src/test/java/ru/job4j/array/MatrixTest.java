package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void when5on5() {
        Matrix array = new Matrix();
        int[][] result = array.multiple(5);
        int expect[][] = {
                {1,  2,  3,  4,  5},
                {2,  4,  6,  8, 10},
                {3,  6,  9, 12, 15},
                {4,  8, 12, 16, 20},
                {5, 10, 15, 20, 25}
        };
        assertThat(result, is(expect));
    }

}
