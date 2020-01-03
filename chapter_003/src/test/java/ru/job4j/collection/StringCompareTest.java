package ru.job4j.collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero () {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));

        System.out.println("Ivanov".compareTo("Ivanov"));
        System.out.println("Ivanov".compareTo("Ivanova"));
        System.out.println("Petrov".compareTo("Ivanova"));
        System.out.println("Petrov".compareTo("Patrov"));
        System.out.println("Patrova".compareTo("Petrov"));

        Set<String> names = new TreeSet<String>();
        names.add("Ivanov");
        names.add("Ivanova");
        names.add("Petrov");
        names.add("Patrov");
        names.add("Patrova");

        for (String elem : names) {
            System.out.println(elem);
        }
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative () {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive () {
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive(){
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative(){
        StringCompare compare = new StringCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, greaterThan(0));
    }
}