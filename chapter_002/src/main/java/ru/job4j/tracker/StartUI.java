package ru.job4j.tracker;


import java.util.function.Consumer;

public class StartUI {

    private int max;
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        max = menu.getActionLength();
        do {
            menu.show();
            menu.select(input.ask("Select: ", max));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        Tracker tracker = new Tracker();
        Consumer<String> output = System.out::println;
        new StartUI(input, tracker, output).init();
    }
}
