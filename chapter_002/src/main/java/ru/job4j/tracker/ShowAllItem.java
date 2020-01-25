package ru.job4j.tracker;

import java.lang.*;
import java.util.function.Consumer;

public class ShowAllItem extends BaseAction {

    public ShowAllItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        for (Item item : tracker.getAll()) {
            output.accept(String.format("%s %s %s", item.getName(), item.getDescription(), item.getId()));
        }
    }
}
