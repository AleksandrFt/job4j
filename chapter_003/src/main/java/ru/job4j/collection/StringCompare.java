package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        int i = 0;
        while (i < o1.length() - 1 && i < o2.length() - 1) {
            if (o1.charAt(i) != o2.charAt(i)) {
                return Character.compare(o1.charAt(i), o2.charAt(i));
            } else {
                i++;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
