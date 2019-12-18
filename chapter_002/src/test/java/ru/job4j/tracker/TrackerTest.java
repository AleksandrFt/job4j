package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class TrackerTest {

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemByIdThen() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1");
        Item secondItem = new Item("test2", "testDescription2");
        Item thirdItem = new Item("test3", "testDescription3");
        //Добавляем заявки в трекер.
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        //Удаляем первую заявку.
        //tracker.delete(firstItem.getId());
        tracker.delete(thirdItem.getId());
        //Проверяем, что первая заявка не находится.
        //assertNull(tracker.findById(firstItem.getId()));
        assertNull(tracker.findById(thirdItem.getId()));
    }

    @Test
    public void whenGetAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("test1", "testDescription1");
        Item secondItem = new Item("test2", "testDescription2");
        //Добавляем заявки в трекер.
        tracker.add(firstItem);
        tracker.add(secondItem);
        //находим все заявки в классе трекер и добавляем их в новый массив..
        ArrayList<Item> array = tracker.getAll();
        //Проверяем, что ID заявок в классе трекер соотвествуют ID заявкам в новом массиве заявок.
        assertThat(firstItem.getId().equals(array.get(0).getId()), is(true));
        assertThat(secondItem.getId().equals(array.get(1).getId()), is(true));
    }

    @Test
    public void whenFindByNameThen() {
        Tracker tracker = new Tracker();
        //Создаем три объекта, из них два с одинаковыми именами.
        Item firstItem = new Item("test1", "testDescription1");
        Item secondItem = new Item("test2", "testDescription2");
        Item thirdItem = new Item("test2", "testDescription3");
        //Добавляем заявки в трекер.
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        //Находим заявку по имени.
        ArrayList<Item> array = tracker.findByName("test2");
        //Проверяем, что ID второя и третьей заявки в новом массиве эквивалентны ID первой и второй завки в новом массиве.
        assertThat(secondItem.getId().equals(array.get(0).getId()), is(true));
        //Проверяем по именам.
        assertThat(thirdItem.getName(), is("test2"));
    }

    @Test
    public void whenFindByIdThen() {
        Tracker tracker = new Tracker();
        //Создаем три объекта, из них два с одинаковыми именами.
        Item firstItem = new Item("test1", "testDescription1");
        Item secondItem = new Item("test2", "testDescription2");
        //Добавляем заявки в трекер.
        tracker.add(firstItem);
        tracker.add(secondItem);
        //Назначаем ID у первого итема.
        firstItem.setId("12345");
        //Сравниваем ссылки на объекты..
        assertThat(tracker.findById("12345").getName(), is("test1"));
    }

    @Test
    public void whenFindByDescriptionThen() {
        Tracker tracker = new Tracker();
        //Создаем три объекта, из них два с одинаковыми именами.
        Item firstItem = new Item("test1", "testDescription1");
        Item secondItem = new Item("test2", "testDescription2");
        //Добавляем заявки в трекер.
        tracker.add(firstItem);
        tracker.add(secondItem);
        firstItem.setDescription("Первая заявка в трекере.");
        assertThat(tracker.findByDescription("Первая").getDescription(), is("Первая заявка в трекере."));
    }
}
