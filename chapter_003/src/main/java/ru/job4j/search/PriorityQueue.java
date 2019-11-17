package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        }
        for (int x = 0; x < tasks.size(); x++) {
            if (task.getPriority() < tasks.get(x).getPriority()) {
                tasks.add(x, task);
                break;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
