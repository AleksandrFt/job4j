package ru.job4j.tracker;

import java.util.*;
import java.util.function.Consumer;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public int getActionLength() {
        return actions.size();
    }

    public void fillActions() {
        this.actions.add(new ExitProgram(0, "Exit program."));
        this.actions.add(new AddItem(1, "Add new item."));
        this.actions.add(new ShowAllItem(2, "Show all items."));
        this.actions.add(new EditItem(3, "Edit item."));
        this.actions.add(new DeleteItem(4, "Delete Item by ID."));
        this.actions.add(new FindByIdItem(5, "Find by ID."));
        this.actions.add(new FindAllByNameItem(6, "Find all items by name."));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, this.output);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
}
