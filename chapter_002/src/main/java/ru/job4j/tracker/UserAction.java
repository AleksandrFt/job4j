package ru.job4j.tracker;

public interface UserAction {

    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
