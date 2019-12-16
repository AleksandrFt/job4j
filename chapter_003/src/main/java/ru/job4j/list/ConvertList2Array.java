package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray (List<Integer> list, int rows) {
        int cells = (int)Math.ceil((double)list.size() / (double)rows);

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

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        Iterator<int[]> it = list.iterator();

        while(it.hasNext()) {
            int[] elem = it.next();
            for (int i = 0; i < elem.length; i++) {
                result.add(elem[i]);
            }
        }
        return result;
    }
}
