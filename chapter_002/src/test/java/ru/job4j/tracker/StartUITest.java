package ru.job4j.tracker;

public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"1", "первая заявка из тестового класса!", "Описание к первой заявке из тестового класса", "2", "0"});
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}
