package ru.job4j.streamapi;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        students = students.stream()
                .filter(predict)
                .collect(Collectors.toList());
        return students;
    }

    public Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(e -> e.getSurname(), e -> e));
    }
}
