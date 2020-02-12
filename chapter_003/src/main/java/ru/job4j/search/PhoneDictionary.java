package ru.job4j.search;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public List<Person> find(String key) {
        return persons.stream()
                .filter(person -> person.getName().contains(key)
                        || person.getSurname().contains(key)
                        || person.getPhone().contains(key)
                        || person.getAddress().contains(key))
                .collect(Collectors.toList());
    }
}
