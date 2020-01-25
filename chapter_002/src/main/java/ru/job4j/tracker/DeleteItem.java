package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String answer = input.ask("Введите ID заявки : ");
        if (tracker.delete(answer)) {
            output.accept("Заявка успешно удалена");
        } else {
            output.accept("Что то пошло не так, попробуйте еще раз");
        }
    }
}
