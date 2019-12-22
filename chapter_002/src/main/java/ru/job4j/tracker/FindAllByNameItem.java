package ru.job4j.tracker;

import java.util.ArrayList;

public class FindAllByNameItem extends BaseAction {

    public FindAllByNameItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите имя заявки для поиска совпадений : ");
        ArrayList<Item> arrayByName = tracker.findByName(answer);
        if (arrayByName.size() != 0) {
            for (Item item : arrayByName) {
                System.out.printf("%s %s %s%n", item.getName(), item.getDescription(), item.getId());
            }
        } else {
            System.out.println("Ничего не найдено, попробуйте поискать что то еще");
        }
    }
}
