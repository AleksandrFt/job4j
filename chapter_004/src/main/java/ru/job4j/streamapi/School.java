package ru.job4j.streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        students = students.stream()
                .filter(predict)
                .collect(Collectors.toList());
        return students;
    }

    public Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(e -> e.getSurname(), e -> e));
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                    .flatMap(Stream::ofNullable)
                    .sorted()
                    .takeWhile(x -> x.getScore() > bound)
                    .collect(Collectors.toList());
    }
}
