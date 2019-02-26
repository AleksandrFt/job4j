package ru.job4j.tracker;

public class FindAllByNameItem implements UserAction {

    @Override
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите имя заявки для поиска совпадений : ");
        Item[] arrayByName = tracker.findByName(answer);
        if (arrayByName.length != 0) {
            for (Item item : arrayByName) {
                System.out.printf("%s %s %s", item.getName(), item.getDescription(), item.getId());
            }
        } else {
            System.out.println("Ничего не найдено, попробуйте поискать что то еще");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Find all items by name.");
    }
}
