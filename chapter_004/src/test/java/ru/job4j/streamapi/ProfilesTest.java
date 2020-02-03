package ru.job4j.streamapi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void giveListAddressFromProfiles() {
            Address address1 = new Address("Moscow", "Lomonosova", 11, 105);
            Address address2 = new Address("Oryol", "Leskova", 34, 10);
            Address address3 = new Address("Magadan", "Lenina", 60, 55);
            Profile profile1 = new Profile(address1);
            Profile profile2 = new Profile(address2);
            Profile profile3 = new Profile(address3);
            List<Profile> profiles = Arrays.asList(profile1, profile2, profile3);
            List<Address> expected = Arrays.asList(address1, address2, address3);
            List<Address> listAddress = new Profiles().collect(profiles);
            assertThat(listAddress, is(expected));
    }
}
