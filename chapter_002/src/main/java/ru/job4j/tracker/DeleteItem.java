package ru.job4j.tracker;

public class DeleteItem implements UserAction{

    @Override
    public int key() {
        return 4;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String answer = input.ask("Введите ID заявки : ");
        if (tracker.delete(answer)) {
            System.out.println("Заявка успешно удалена");
        } else {
            System.out.println("Что то пошло не так, попробуйте еще раз");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Delete Item by ID.");
    }
}
