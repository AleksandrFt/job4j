package ru.job4j.tracker;

import java.util.function.Consumer;

public class EditItem extends BaseAction {

    public EditItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String answer = input.ask("Введите ID заявки, которую хотите изменить : ");
        String name = input.ask("Введите имя:");
        String desc = input.ask("Введите описание:");
        if (tracker.replace(answer, new Item(name, desc))) {
            output.accept("Заявка успешно отредактирована");
        } else {
            output.accept("Заявка с данным ID: " + answer + " - не найдена");
        }
    }
}
