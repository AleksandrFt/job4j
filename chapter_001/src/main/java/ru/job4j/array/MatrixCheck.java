package ru.job4j.array;

/**
 * Class check matrix.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class MatrixCheck {

    /**
     * Method check matrix.
     * @param data array.
     * @return true or false.
     */
    public boolean mono(boolean[][] data) {

        boolean result = true;

        int size = data.length;
        int index = 0;
        while (++index < size) {
            if ((data[0][0] != data[index][index]) && (data[0][size - 1] != data[index][size - 1 - index])) {
                result = false;
                break;
            }
        }
        //while (++index < size) {
        //    if (data[0][size - 1] != data[index][size - 1 - index]) {
        //        result = false;
        //    }
        //}
        return result;
    }
}
