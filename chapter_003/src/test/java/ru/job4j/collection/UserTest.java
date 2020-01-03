package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        users.add(new User("Ivan", 33));
        users.add(new User("Ivan", 32));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Ivan", 32)));
        assertThat(it.next(), is(new User("Ivan", 33)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUsersSortByName() {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 32));
        users.add(new User("Alex", 31));
        users.add(new User("Brain", 33));
        users.add(new User("Tom", 34));
        Collections.sort(users, new userSortByName());
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Alex", 31)));
        assertThat(it.next(), is(new User("Brain", 33)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Tom", 34)));
    }

    @Test
    public void whenUsersSortByAge() {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 32));
        users.add(new User("Alex", 31));
        users.add(new User("Brain", 33));
        users.add(new User("Tom", 34));
        Collections.sort(users, new userSortByAge());
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Alex", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Brain", 33)));
        assertThat(it.next(), is(new User("Tom", 34)));
    }

    @Test
    public void whenUsersSortByNameDesc() {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 32));
        users.add(new User("Alex", 31));
        users.add(new User("Brain", 33));
        users.add(new User("Tom", 34));
        Collections.sort(users, new userSortByNameDesc());
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Tom", 34)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Brain", 33)));
        assertThat(it.next(), is(new User("Alex", 31)));
    }

    @Test
    public void whenUsersSortByAgeDesc() {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 32));
        users.add(new User("Alex", 31));
        users.add(new User("Brain", 33));
        users.add(new User("Tom", 34));
        Collections.sort(users, new userSortByAgeDesc());
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Tom", 34)));
        assertThat(it.next(), is(new User("Brain", 33)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Alex", 31)));
    }

    @Test
    public void whenUsersSortByNameAndAge() {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 32));
        users.add(new User("Alex", 31));
        users.add(new User("Brain", 33));
        users.add(new User("Tom", 29));
        users.add(new User("Brain", 28));
        users.add(new User("Tom", 34));
        Collections.sort(users, new userSortByName().thenComparing(new userSortByAge()));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Alex", 31)));
        assertThat(it.next(), is(new User("Brain", 28)));
        assertThat(it.next(), is(new User("Brain", 33)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Tom", 29)));
        assertThat(it.next(), is(new User("Tom", 34)));
    }

    @Test
    public void whenUsersSortByAgeAndNameDesc() {
        List<User> users = new ArrayList<>();
        users.add(new User("Petr", 32));
        users.add(new User("Alex", 32));
        users.add(new User("Brain", 33));
        users.add(new User("Tom", 29));
        users.add(new User("Brain", 28));
        users.add(new User("Tom", 32));
        Collections.sort(users, new userSortByAgeDesc().thenComparing(new userSortByNameDesc()));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Brain", 33)));
        assertThat(it.next(), is(new User("Tom", 32)));
        assertThat(it.next(), is(new User("Petr", 32)));
        assertThat(it.next(), is(new User("Alex", 32)));
        assertThat(it.next(), is(new User("Tom", 29)));
        assertThat(it.next(), is(new User("Brain", 28)));
    }
}
