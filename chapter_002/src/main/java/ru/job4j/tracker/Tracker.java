package ru.job4j.tracker;

import java.util.*;

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
        boolean result = false;
        for (int i = 0; i != items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                item.setId(this.items.get(i).getId());
                this.items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявку в трекере.
     * @param id удаляемой заявки.
     * @return true, если заявка была удалена.
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                    this.items.remove(i);
                    result = true;
                    break;
                }
            }
        return result;
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
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Поиск заявок по ID.
     * @param id заявки.
     * @return item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * Метод ищет по описанию.
     * @param word слово.
     * @return item.
     */
    public Item findByDescription(String word) {
        Item result = null;
        for (Item item : items) {
            if (item.getDescription().contains(word)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует ID для завкию
     * @return уникальное число.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
