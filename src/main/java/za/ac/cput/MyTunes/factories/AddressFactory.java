package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.Address;

public class AddressFactory {

    public static Address createAddress(String address, String city, String country, String zipCode) {
        return new Address.Builder(address).city(city).country(country).zipCode(zipCode).build();
    }

}
