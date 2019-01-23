package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {

    @Test
    public void whenTableReturnTrue() {
        MatrixCheck checker = new MatrixCheck();
        boolean[][] table = new boolean[][] {
            {true, true, true},
            {false, true, true},
            {true, false, true}
        };
        boolean result = checker.mono(table);
        assertThat(result, is(true));
    }

    @Test
    public void wgenTableReturnFalse() {
        MatrixCheck checker = new MatrixCheck();
        boolean[][] table = new boolean[][] {
                {true, false, true},
                {false, false, false},
                {true, false, true}
        };
        boolean result = checker.mono(table);
        assertThat(result, is(false));
    }

}
