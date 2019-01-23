package ru.job4j.array;

/**
 * Class matrix.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class Matrix {

    /**
     * Method fills table.
     * @param size height*width.
     * @return array.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
