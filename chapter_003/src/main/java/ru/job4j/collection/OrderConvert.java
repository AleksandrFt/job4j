package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.toMap(Order::getNumber, x -> x, (prev, next) -> next, HashMap::new));
    }
}
