package ru.job4j.streamapi;


public class Student implements Comparable<Student> {
    public int score;
    private String name;
    private String surname;

    public Student(int score) {
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, String surname, int score) {
        this.name = name;
        this.surname = surname;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.getScore(), this.score);
    }
}
