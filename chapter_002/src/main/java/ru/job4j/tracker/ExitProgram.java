package ru.job4j.tracker;

public class ExitProgram implements UserAction {

    @Override
    public int key() {
        return 0;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.exit(0);
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Exit program.");
    }
}
