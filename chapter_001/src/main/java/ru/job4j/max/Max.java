package ru.job4j.max;

/**
 * @author afateev
 * @since 1.0
 * @version 1.0
 */

public class Max {

    /**
     * Method compare 2 numbers.
     * @param first первое число.
     * @param second второе число.
     * @return максимум из двух чисел.
     */
    public int max(int first, int second) {
        return first >= second ? first : second;
    }

    /**
     * Method compare 3 number.
     * @param first первое число.
     * @param second второе число.
     * @param third третье число.
     * @return максимум из 3 чисел.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
