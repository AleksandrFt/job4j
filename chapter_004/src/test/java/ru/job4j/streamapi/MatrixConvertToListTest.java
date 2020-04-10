package ru.job4j.streamapi;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixConvertToListTest {

    @Test
    public void matrixConvertToListInteger() {
        MatrixConvertToList matrixToList = new MatrixConvertToList();
        Integer[][] matrix = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        List<Integer> result = matrixToList.convert(matrix);
        List<Integer> expected = List.of(3, 2, 1, 6, 5, 4, 9, 8, 7);
        assertThat(result, is(expected));
    }
}
