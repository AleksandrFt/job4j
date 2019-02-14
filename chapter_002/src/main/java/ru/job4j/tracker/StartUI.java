package ru.job4j.tracker;



public class StartUI {

    private static final String EXIT = "0";
    private static final String ADD = "1";
    private static final String SHOW_ALL = "2";
    private static final String EDIT = "3";
    private static final String DELETE = "4";
    private static final String FIND_BY_ID = "5";
    private static final String FIND_ALL_BY_NAME = "6";
    private final Input input;
    private final Tracker tracker;

    String[] menu = {
        "1. Создать новую заявку.",
        "2. Показать все заявки.",
        "3. Отредактировать заявку.",
        "4. Удалить заявку.",
        "5. Найти заявку по ее ID",
        "6. Найти заявку по имени",
        "0. Выйти из программы."
    };

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Выберите пункт меню : ");

            if (ADD.equals(answer)) {
                Item item = tracker.add(this.createItem());
                System.out.println("Заявка успешно добавлена : " + item.getName());
                System.out.println("---------------------------------------------------------------");
            } else if (SHOW_ALL.equals(answer)) {
                for (Item item : tracker.getAll()) {
                    System.out.println("Имя : " + item.getName() + " Описание : " + item.getDescription() + " ID : " + item.getId());
                }
                System.out.println("---------------------------------------------------------------");
            } else if (EDIT.equals(answer)) {
                answer = this.input.ask("Введите ID заявки, которую хотите изменить : ");
                if (tracker.findById(answer) != null) {
                    if (tracker.replace(answer, this.createItem())) {
                    System.out.println("Заявка успешно отредактирована");
                    System.out.println("---------------------------------------------------------------");
                    }
                } else {
                    System.out.println("Заявка с данным ID: " + answer + " - не найдена");
                    System.out.println("---------------------------------------------------------------");
                }
            } else if (DELETE.equals(answer)) {
                answer = this.input.ask("Введите ID заявки : ");
                if (tracker.delete(answer)) {
                    System.out.println("Заявка успешно удалена");
                    System.out.println("---------------------------------------------------------------");
                } else {
                    System.out.println("Что то пошло не так, попробуйте еще раз");
                    System.out.println("---------------------------------------------------------------");
                }
            } else if (FIND_BY_ID.equals(answer)) {
                answer = this.input.ask("Введите ID заявки : ");
                Item item = tracker.findById(answer);
                System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
                System.out.println("---------------------------------------------------------------");
            } else if (FIND_ALL_BY_NAME.equals(answer)) {
                answer = this.input.ask("Введите имя заявки для поиска совпадений : ");
                Item[] arrayByName = tracker.findByName(answer);
                if (arrayByName.length != 0) {
                    for (Item item : arrayByName) {
                        System.out.println(item.getName() + " " + item.getDescription() + " " + item.getId());
                    }
                } else {
                    System.out.println("Ничего не найдено, попробуйте поискать что то еще");
                    System.out.println("---------------------------------------------------------------");
                    }
                } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Попробуйте ввести еще раз");
                System.out.println("---------------------------------------------------------------");
            }
        }
    }

    public void showMenu() {
        for (String string : menu) {
            System.out.println(string);
        }
    }

    public Item createItem() {
        String name = this.input.ask("Введите название новой заявки : ");
        String description = this.input.ask("Введите описание новой заявки : ");
        return new Item(name, description);
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}
