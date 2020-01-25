package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }

    public int ask(String question, int max) throws MenuOutException, NumberFormatException {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        if (key < max) {
            exist = true;
        }
        if (!exist) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}
