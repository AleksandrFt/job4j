package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        char[] result1 = o1.toCharArray();
        char[] result2 = o2.toCharArray();
        int sum1 = 0;
        int sum2 = 0;

        for (char elem : result1) {
            sum1 = sum1 + (int)elem;
        }
        for (char elem : result2) {
            sum2 = sum2 + (int)elem;
        }
        return sum1 - sum2;
    }
}
