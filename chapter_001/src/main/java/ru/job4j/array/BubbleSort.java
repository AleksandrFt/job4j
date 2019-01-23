package ru.job4j.array;

/**
 * Class sorts bubble method.
 * @author afateev
 * @version 1.0
 * @since 1.0
 */

public class BubbleSort {

    /**
     * Method sorts the array with bubble sort algorithm.
     * @param array Unsorted array.
     * @return Sorted array.
     */
    public int[] sort(int[] array) {

        int index = 0;
        int length = array.length;

        //Пока индекс элемента массива меньше длины неотсортированной части массива, продолжаем сортировать массив.
        while (index < length - 1) {

            //Проверка и перестановка в случае необходимости.
            if (array[index] > array[index + 1]) {
                int buf = array[index];
                array[index] = array[index + 1];
                array[index + 1] = buf;
            }
            index++;

            /*Проверяем, если индекс текущего элемента равен длине неотсортированной части,
            то возвращаемся на нулевой элемент массива и
            снижаем переменную длинны неотсортированной части.*/
            if (index == length - 1) {
                index = 0;
                length--;
            }
        }
        return array;
    }
}
