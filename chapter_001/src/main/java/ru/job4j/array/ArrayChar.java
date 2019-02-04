package ru.job4j.array;

/**
 * Class checks prefix.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class ArrayChar {
    private char[] data;

    /**
     * Method translate String to array of char.
     *
     * @param line String.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Method checks prefix and start of string.
     *
     * @param prefix Префикс.
     * @return True ot False.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int index = 0; index < value.length; index++) {
            if (value[index] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
