package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {

    public int[][] toArray (List<Integer> list, int rows) {
        int cells = 0;
        if (list.size() % rows > 0) {
            cells = (list.size() / rows) + 1;
        } else {
            cells = list.size() / rows;
        }

        int[][] array = new int[rows][cells];

        int firstIndex = 0;
        int secondIndex = 0;

        for (Integer x : list) {
            array[firstIndex][secondIndex] = x;
            secondIndex++;
            if (secondIndex == cells) {
                firstIndex++;
                secondIndex = 0;
            }
        }
        return array;
    }
}
