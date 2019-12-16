package ru.job4j.list;
import org.junit.Test;
import ru.job4j.list.ConvertList2Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void when2ListThen1List() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> listInteger = new ArrayList<>();
        listInteger.add(new int[]{1, 2});
        listInteger.add(new int[]{3, 4, 5, 6});

        List<Integer> result = list.convert(listInteger);
        List<Integer> expect = new ArrayList();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        expect.add(5);
        expect.add(6);
        assertThat(result, is(expect));
    }
}
