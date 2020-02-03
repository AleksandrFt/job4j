package ru.job4j.streamapi;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        students = students.stream()
                .filter(predict)
                .collect(Collectors.toList());
        return students;
    }
}
