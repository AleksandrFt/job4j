package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {

    @Test
    public void whenArrayHasDuplicatesThenDropIt() {
        ArrayDuplicate dropDuplicate = new ArrayDuplicate();
        String[] notSorted = {"торт", "мир", "привет", "мир", "мир", "торт", "вася", "петя", "петя"};
        String[] result = dropDuplicate.remove(notSorted);
        String[] expect = {"торт", "мир", "привет", "вася", "петя"};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }
}
