package ru.job4j.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
        List<Address> addressList = profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
        return addressList;
    }
}
