package ru.job4j.loop;

/**
 * Class calculate the sum of even numbers.
 * @author afateev
 * @version 1.0
 * @since 1.0
 *
 */

public class Counter {

    /**
     * Method calculates sum of even numbers in sequence.
     * @param start Start sequence.
     * @param finish Finish sequence.
     * @return Sum of even in sequence.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int number = start; number <= finish; number++) {
            if (number % 2 == 0) {
                sum = sum + number;
            }
        }
        return sum;
    }
}
