package ru.job4j.array;

import java.util.Arrays;

/**
 * Class remove duplicate strings.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class ArrayDuplicate {

    /**
     * Method remove duplicate.
     * @param array strings.
     * @return Sorted array.
     */
    public String[] remove(String[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i].equals(array[j])) {
                    String buf = array[j];
                    array[j] = array[length - 1];
                    array[length - 1] = buf;
                    length--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, length);
    }
}
