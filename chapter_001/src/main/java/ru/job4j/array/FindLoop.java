package ru.job4j.array;

import java.util.*;

/**
 * Class simple search.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class FindLoop {

    /**
     * Method searching number in array.
     * @param data array.
     * @param el number.
     * @return index.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (el == data[index]) {
                rst = index;
            }
        }
        return rst;
    }
}
