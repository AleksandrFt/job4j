package ru.job4j.tracker;

public class ExitProgram extends BaseAction {

    public ExitProgram(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.exit(0);
    }
}
