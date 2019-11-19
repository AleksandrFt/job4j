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
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int cell = 0; cell < cells; cell++) {
                array[row][cell] = list.get(index);
                if (index == list.size() - 1) {
                    break;
                }
                index++;
            }
        }
        return array;
    }
}
