package ru.job4j.tracker;

import java.lang.*;

public class ShowAllItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.getAll()) {
            System.out.printf("%s %s %s%n", item.getName(), item.getDescription(), item.getId());
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Show all items.");
    }
}
