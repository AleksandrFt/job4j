package ru.job4j.tracker;

import java.util.*;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionLength() {
        return actions.size();
    }

    public void fillActions() {
        this.actions.add(new ExitProgram());
        this.actions.add(new AddItem());
        this.actions.add(new ShowAllItem());
        this.actions.add(new EditItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindByIdItem());
        this.actions.add(new FindAllByNameItem());
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
