package ru.job4j.tracker;

public class DeleteItem extends BaseAction{

    public DeleteItem(int key, String name) {
        super(key, name);
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
}
