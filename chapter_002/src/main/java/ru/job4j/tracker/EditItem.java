package ru.job4j.tracker;

public class EditItem implements UserAction {

    @Override
    public int key() {
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите ID заявки, которую хотите изменить : ");
        String name = input.ask("Введите имя:");
        String desc = input.ask("Введите описание:");
        if (tracker.replace(answer, new Item(name, desc))) {
            System.out.println("Заявка успешно отредактирована");
        } else {
            System.out.println("Заявка с данным ID: " + answer + " - не найдена");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edit item.");
    }
}
