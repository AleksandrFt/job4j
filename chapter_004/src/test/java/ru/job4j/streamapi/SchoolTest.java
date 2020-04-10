package ru.job4j.streamapi;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {

    @Test
    public void whenDiapasonFrom0To50() {
        School school = new School();

        Student student1 = new Student(85);
        Student student2 = new Student(5);
        Student student3 = new Student(55);
        Student student4 = new Student(15);
        Student student5 = new Student(75);
        Student student6 = new Student(65);
        List<Student> students = List.of(student1, student2, student3, student4,
                student5, student6);

        List<Student> lowSchool = school.collect(students, x -> x.getScore() < 50);
        List<Student> expected = List.of(student2, student4);

        assertThat(lowSchool, is(expected));
    }

    @Test
    public void whenDiapasonFrom50To70() {
        School school = new School();

        Student student1 = new Student(85);
        Student student2 = new Student(5);
        Student student3 = new Student(55);
        Student student4 = new Student(15);
        Student student5 = new Student(75);
        Student student6 = new Student(65);
        List<Student> students = List.of(student1, student2, student3, student4,
                student5, student6);

        List<Student> middleSchool = school.collect(students, x -> 50 <= x.getScore() && x.getScore() < 70);
        List<Student> expected = List.of(student3, student6);

        assertThat(middleSchool, is(expected));
    }

    @Test
    public void whenDiapasonFrom70To100() {
        School school = new School();

        Student student1 = new Student(85);
        Student student2 = new Student(5);
        Student student3 = new Student(55);
        Student student4 = new Student(15);
        Student student5 = new Student(75);
        Student student6 = new Student(65);
        List<Student> students = List.of(student1, student2, student3, student4,
                student5, student6);

        List<Student> highSchool = school.collect(students, x -> 70 <= x.getScore() && x.getScore() <= 100);
        List<Student> expected = List.of(student1, student5);

        assertThat(highSchool, is(expected));
    }

    @Test
    public void convertListToMap() {
        School school = new School();
        Student student1 = new Student("Ivan", "Sidorov", 85);
        Student student2 = new Student("Nikola", "Petrov", 5);
        Student student3 = new Student("Svetlana", "Korotkova", 55);
        List<Student> students = List.of(student1, student2, student3);
        Map<String, Student> studentMap = school.convertListToMap(students);
        Map<String, Student> expected = new HashMap();
        expected.put("Sidorov", student1);
        expected.put("Petrov", student2);
        expected.put("Korotkova", student3);
        assertThat(studentMap, is(expected));
    }

    @Test
    public void sortListStudentAndReturnGroupStudent() {
        School school = new School();

        Student student1 = new Student("Sasha", 85);
        Student student2 = new Student("Vasja", 5);
        Student student3 = new Student("Petya", 55);
        Student student4 = new Student("Klava", 15);
        Student student5 = new Student("Anna", 75);
        Student student6 = new Student("Tanya", 65);
        List<Student> students = List.of(student1, student2, student3, student4,
                student5, student6);

        List<Student> highSchool = school.levelOf(students, 50);
        List<Student> expected = List.of(student1, student5, student6, student3);

        assertThat(highSchool, is(expected));
    }
}
