package ru.job4j.tracker;

public class FindByIdItem implements UserAction {

    @Override
    public int key() {
        return 5;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите ID заявки : ");
        Item item = tracker.findById(answer);
        System.out.printf("%s %s %s%n", item.getName(), item.getDescription(), item.getId());
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find by ID.");
    }
}
