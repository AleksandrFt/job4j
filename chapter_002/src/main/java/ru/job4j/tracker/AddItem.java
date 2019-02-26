package ru.job4j.tracker;

public class AddItem implements UserAction{

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Введите имя:");
        String desc = input.ask("Введите описание:");
        tracker.add(new Item(name, desc));
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Add new item.");
    }
}
