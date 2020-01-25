package ru.job4j.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"5", "0"}));
        input.ask("Enter", 3);
        assertThat(this.mem.toString(), is(String.format("Please select key from menu%n")));
    }

    @Test
    public void whenEnterOutOfRange() {
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"invalid", "0"}));
        input.ask("Enter", 3);
        assertThat(this.mem.toString(), is(String.format("Please enter validate data again%n")));
    }
}
