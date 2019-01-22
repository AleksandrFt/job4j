package ru.job4j.array;

/**
 * Class check array.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class Chek {

    /**
     * Method check array.
     * @param data boolean array.
     * @return true or false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 1; index < data.length; index++) {
            if (data[0] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
