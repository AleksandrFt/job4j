package ru.job4j.tracker;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("Execute before method.");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("Execute after method.");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "первая заявка", "первое описание", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("первая заявка"));
    }

    @Test
    public void whenUserDeleteFirstItemThenTrackerDropFirstItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("первая заявка", "первое описание")).setId("12345");
        Input input = new StubInput(new String[]{"1", "вторая заявка", "второе описание", "", "4", "12345", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("вторая заявка"));
    }

    @Test
    public void whenUserEditItemThenItemChangeNameAndDescription() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("первая заявка", "первое описание")).setId("12345");
        Input input = new StubInput(new String[]{"1", "вторая заявка", "второе описание", "",
                "3", "12345", "новое имя первой заявки", "новое описание первой заявки", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("новое имя первой заявки"));
    }

    @Test
    public void whenUserChoseShowAllItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("первая заявка", "первое описание")).setId("12345");
        tracker.add(new Item("вторая заявка", "второе описание")).setId("67890");
        Input input = new StubInput(new String[]{"2", "y"});
        new StartUI(input, tracker).init();
        String string = new String(out.toByteArray());
        assertThat(string, is(String.join(System.getProperty("line.separator"),
                "0. Exit program.",
                "1. Add new item.",
                "2. Show all items.",
                "3. Edit item.",
                "4. Delete Item by ID.",
                "5. Find by ID.",
                "6. Find all items by name.",
                "первая заявка первое описание 12345",
                "вторая заявка второе описание 67890",
                ""))
        );
    }

    @Test
    public void whenUserChoseFindById() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("первая заявка", "первое описание")).setId("12345");
        Input input = new StubInput(new String[]{"5", "12345", "y"});
        new StartUI(input, tracker).init();
        String string = new String(out.toByteArray());
        assertThat(string, is(String.join(System.getProperty("line.separator"),
                "0. Exit program.",
                "1. Add new item.",
                "2. Show all items.",
                "3. Edit item.",
                "4. Delete Item by ID.",
                "5. Find by ID.",
                "6. Find all items by name.",
                "первая заявка первое описание 12345",
                ""))
        );
    }

    @Test
    public void whenUserChoseFindAllByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("первая", "первое описание")).setId("12345");
        tracker.add(new Item("вторая", "второе описание")).setId("54321");
        tracker.add(new Item("первая", "третье описание")).setId("67890");
        Input input = new StubInput(new String[]{"6", "первая", "y"});
        new StartUI(input, tracker).init();
        String string = new String(out.toByteArray());
        assertThat(string, is(String.join(System.getProperty("line.separator"),
                "0. Exit program.",
                "1. Add new item.",
                "2. Show all items.",
                "3. Edit item.",
                "4. Delete Item by ID.",
                "5. Find by ID.",
                "6. Find all items by name.",
                "первая первое описание 12345",
                "первая третье описание 67890",
                ""))
        );
    }
}
