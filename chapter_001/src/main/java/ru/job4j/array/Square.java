package ru.job4j.array;

/**
 * The class fills the array with powers of integers.
 * @author afateev
 * @version 1.0
 * @since 1.0
 *
 */

public class Square {

    /**
     * Method fills the array with powers of integers.
     * @param bound Integer number.
     * @return array with integer numbers.
     */
    public int[] calculate (int bound) {
        int[] rst = new int[bound];
        int first = 1;
        for (int index = 0; index < bound; index++, first++) {
            rst[index] = first * first;
        }
        return rst;
    }

}
