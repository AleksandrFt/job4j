package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.addFirst(task);
        }
        if (tasks.size() == 1) {
            if (task.getPriority() < tasks.get(0).getPriority()) {
                tasks.addFirst(task);
            } else {
                tasks.addLast(task);
            }
        }

        for (int x = 1; x < tasks.size(); x++) {
            if (task.getPriority() < tasks.get(x - 1).getPriority()) {
                tasks.addFirst(task);
                break;
            } else if (task.getPriority() > tasks.get(x - 1).getPriority()
                    && task.getPriority() < tasks.get(x).getPriority()) {
                tasks.add(x, task);
                break;
            } else if (task.getPriority() > tasks.get(x).getPriority() && x == tasks.size() - 1) {
                tasks.addLast(task);
                break;
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
