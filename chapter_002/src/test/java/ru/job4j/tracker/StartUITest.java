package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "первая заявка", "первое описание", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("первая заявка"));
    }

    @Test
    public void whenUserDeleteFirstItemThenTrackerDropFirstItem() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("первая заявка", "первое описание")).setId("12345");
        Input input = new StubInput(new String[]{"1", "вторая заявка", "второе описание", "4", "12345", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("вторая заявка"));
    }

    @Test
    public void whenUserEditItemThenItemChangeNameAndDescription() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("первая заявка", "первое описание")).setId("12345");
        Input input = new StubInput(new String[]{"1", "вторая заявка", "второе описание",
                "3", "12345", "новое имя первой заявки", "новое описание первой заявки", "0"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("новое имя первой заявки"));
    }
}
