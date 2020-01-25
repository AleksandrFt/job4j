package ru.job4j.tracker;

import java.util.function.Consumer;

public class ExitProgram extends BaseAction {

    public ExitProgram(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        System.exit(0);
    }
}
