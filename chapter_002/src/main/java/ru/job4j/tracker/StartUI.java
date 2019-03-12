package ru.job4j.tracker;



public class StartUI {

    private int[] range;
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        range = new int[menu.getActionLength()];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        do {
            menu.show();
            menu.select(input.ask("Select: ", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}
