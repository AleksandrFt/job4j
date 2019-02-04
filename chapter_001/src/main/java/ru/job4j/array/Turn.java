package ru.job4j.array;

/**
 * Class turn around array.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class Turn {

    /**
     * Method turn array.
     * @param array массив.
     * @return перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length / 2; index++) {
            int tmp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = tmp;
        }
        return array;
    }
}
