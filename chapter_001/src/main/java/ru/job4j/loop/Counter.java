package ru.job4j.loop;

/**
 * Class calculate the sum of even numbers.
 * @author afateev
 * @version 1.0
 * @since 1.0
 *
 */

public class Counter {

    public int add(int start, int finish) {

        int sum = 0;

        for (int number = start; number <= finish; number++) {
            if (number % 2 == 0) {
                sum = sum + number;
            }
        }

        return sum;



        /*
        while (number <= finish) {
            if (number % 2 == 0) {
                sum = sum + number;
                number++;
            } else {
                number++;
            }
        }
        return sum;
        */
    }
}
