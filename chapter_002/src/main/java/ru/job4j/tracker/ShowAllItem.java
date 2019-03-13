package ru.job4j.tracker;

import java.lang.*;

public class ShowAllItem extends BaseAction {

    public ShowAllItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.getAll()) {
            System.out.printf("%s %s %s%n", item.getName(), item.getDescription(), item.getId());
        }
    }
}
