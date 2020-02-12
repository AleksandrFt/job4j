package ru.job4j.tracker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author afateev
 * @version 1.0
 * @since 1.0
 */
public class Tracker {

    private ArrayList<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * Метод генерирует ID заявки и добавляет ее в трекер.
     * @param item заявка.
     * @return Item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        items.add(item);
        return item;
    }

    /**
     * Метод заменяет заявку одну заявку на другую, не меняя ID заявки.
     * @param id заявки.
     * @param item новая заявка.
     * @return true, если замена случилась.
     */
    public boolean replace(String id, Item item) {
        boolean rsl = false;
        if (findById(id) != null) {
            item.setId(findById(id).getId());
            items.set(items.indexOf(findById(id)), item);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод удаляет заявку в трекере.
     * @param id удаляемой заявки.
     * @return true, если заявка была удалена.
     */
    public boolean delete(String id){
        return items.remove(findById(id));
    }

    /**
     * Метод находит все заявки.
     * @return массив заявок.
     */
    public ArrayList<Item> getAll() {
        return items;
    }

    /**
     * Метод ищет объекты в треке по имени.
     * @param key имя заявки.
     * @return массив заявок.
     */
    public ArrayList<Item> findByName(String key) {
        return items.stream()
                .filter(x -> x.getName().equals(key))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Поиск заявок по ID.
     * @param id заявки.
     * @return item.
     */
    public Item findById(String id) {
        return items.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет по описанию.
     * @param word слово.
     * @return item.
     */
    public Item findByDescription(String word) {
        return items.stream()
                .filter(x -> x.getDescription().contains(word))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод генерирует ID для завкию
     * @return уникальное число.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
