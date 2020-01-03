package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        //int tmp = 0; Character.compare(o1.charAt(i), o2.charAt(i));

        char[] result1 = o1.toCharArray();
        char[] result2 = o2.toCharArray();

        int i = 0;
        while (i < result1.length - 1 && i < result2.length - 1) {
            if (result1[i] > result2[i]) {
                return 1;
            } else if (result1[i] < result2[i]) {
                return -1;
            } else {
                i++;
            }
        }
        return Integer.compare(o2.length(), o1.length());
    }
}
