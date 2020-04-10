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
            Address address2 = new Address("Vladivistok", "Leskova", 34, 10);
            Address address3 = new Address("Oryol", "Leskova", 34, 22);
            Address address4 = new Address("Magadan", "Lenina", 60, 55);
            Address address5 = new Address("Magadan", "Lenina", 60, 55);
            Profile profile1 = new Profile(address1);
            Profile profile2 = new Profile(address2);
            Profile profile3 = new Profile(address3);
            Profile profile4 = new Profile(address4);
            Profile profile5 = new Profile(address5);
            List<Profile> profiles = List.of(profile1, profile2, profile3, profile4, profile5);
            List<Address> expected = List.of(address4, address1, address3, address2);
            List<Address> listAddress = new Profiles().collect(profiles);
            assertThat(listAddress, is(expected));
    }
}
