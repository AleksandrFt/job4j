package ru.job4j.streamapi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Student> students = Arrays.asList(student1, student2, student3, student4,
                student5, student6);

        List<Student> classA = school.collect(students, x -> x.getScore() < 50);
        List<Student> expected = Arrays.asList(student2, student4);

        assertThat(classA, is(expected));
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
        List<Student> students = Arrays.asList(student1, student2, student3, student4,
                student5, student6);

        List<Student> classA = school.collect(students, x -> 50 <= x.getScore() && x.getScore() < 70);
        List<Student> expected = Arrays.asList(student3, student6);

        assertThat(classA, is(expected));
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
        List<Student> students = Arrays.asList(student1, student2, student3, student4,
                student5, student6);

        List<Student> classA = school.collect(students, x -> 70 <= x.getScore() && x.getScore() <= 100);
        List<Student> expected = Arrays.asList(student1, student5);

        assertThat(classA, is(expected));
    }
}
