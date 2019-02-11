package ru.job4j.tracker;

import java.util.*;

/**
 * @author afateev
 * @version 1.0
 * @since 1.0
 */
public class Tracker {

    private Item[] items = new Item[100];
    private static final Random RN = new Random();
    private int position = 0;

    /**
     * Метод генерирует ID заявки и добавляет ее в трекер.
     * @param item заявка.
     * @return Item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
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
        for (int i = 0; i != this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                item.setId(this.items[i].getId());
                this.items[i] = item;
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
        for (int i = 0; i <= this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                if (i < this.position) {
                    System.arraycopy(items, i + 1, items, i, this.position - i);
                    this.position--;
                    result = true;
                    break;
                } else {
                    items[i] = null;
                    this.position--;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод находит все заявки.
     * @return массив заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод ищет объекты в треке по имени.
     * @param key имя заявки.
     * @return массив заявок.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int i = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result[i++] = item;
            }
        }
        return Arrays.copyOf(result, --i);
    }

    /**
     * Поиск заявок по ID.
     * @param id заявки.
     * @return item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
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
