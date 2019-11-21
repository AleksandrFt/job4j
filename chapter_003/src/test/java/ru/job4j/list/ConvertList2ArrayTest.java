package ru.job4j.list;
import org.junit.Test;
import ru.job4j.list.ConvertList2Array;

import java.util.Arrays;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int [][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expect));
    }
}
