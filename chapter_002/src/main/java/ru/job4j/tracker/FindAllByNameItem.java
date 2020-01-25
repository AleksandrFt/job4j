package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.function.Consumer;

public class FindAllByNameItem extends BaseAction {

    public FindAllByNameItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String answer = input.ask("Введите имя заявки для поиска совпадений : ");
        ArrayList<Item> arrayByName = tracker.findByName(answer);
        if (arrayByName.size() != 0) {
            for (Item item : arrayByName) {
                output.accept(String.format("%s %s %s", item.getName(), item.getDescription(), item.getId()));
            }
        } else {
            output.accept("Ничего не найдено, попробуйте поискать что то еще");
        }
    }
}
