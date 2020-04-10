package ru.job4j.search;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Adam", "Freeman", "1233434", "Орел"));
        var key = "Free";
        var persons = phones.find(key);
        assertThat(persons.iterator().next().getSurname(), is("Freeman"));
    }

}
