package ru.job4j.loop;

/**
 * Class calculates factorial to number n.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */
public class Factorial {

    /**
     * Method calculates factorial to number n.
     * @param n Finish number.
     * @return Factorial.
     */
    public int calc(int n) {
        int result = 1;
        if (n > 0) {
            for (int start = 1; start <= n; start++) {
                result = result * start;
            }
        }
        return result;
    }
}
