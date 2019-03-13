package ru.job4j.tracker;

public class AddItem extends BaseAction{

    public AddItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя:");
        String desc = input.ask("Введите описание:");
        tracker.add(new Item(name, desc));
    }
}
