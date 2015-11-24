package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.*;

import java.util.List;

public class CustomerFactory {

    public static Customer createCustomer(Name name, String sex, String dateOfBirth, Contact contact, Address address, List<Order>orderList) {
        return new Customer.Builder(name).sex(sex).dateOfBirth(dateOfBirth).contact(contact).address(address).orderList(orderList).build();
    }

}
