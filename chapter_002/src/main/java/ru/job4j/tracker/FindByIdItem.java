package ru.job4j.tracker;

public class FindByIdItem extends BaseAction {

    public FindByIdItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите ID заявки : ");
        Item item = tracker.findById(answer);
        System.out.printf("%s %s %s%n", item.getName(), item.getDescription(), item.getId());
    }
}
