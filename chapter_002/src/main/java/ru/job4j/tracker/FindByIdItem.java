package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindByIdItem extends BaseAction {

    public FindByIdItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String answer = input.ask("Введите ID заявки : ");
        Item item = tracker.findById(answer);
        output.accept(String.format("%s %s %s", item.getName(), item.getDescription(), item.getId()));
    }
}
