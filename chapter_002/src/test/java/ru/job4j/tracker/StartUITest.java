package ru.job4j.tracker;

public class StartUITest {
    public static void main(String[] args) {
        Input input = new StubInput(new String[] {"Create stub task."});
        new StartUI(input).init();
    }
}
