package ru.job4j.list;
import java.util.List;
import java.util.ArrayList;

public class ConvertMatrix2List {

    public List<Integer> toList(int array[][]) {
        List<Integer> list = new ArrayList<>();

        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }
}
