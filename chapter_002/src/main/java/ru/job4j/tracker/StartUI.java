package ru.job4j.tracker;



public class StartUI {

    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        String name = input.ask("Please enter the task name. ");
        Tracker tracker = new Tracker();
        tracker.add(new Item(name, "first desc"));
        for (Item item : tracker.getAll()) {
            System.out.println(item.getName());
        }
    }

    public static void main(String[] args) {
       // Input input = new StubInput(new String[] {"Create stub task."});
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}
