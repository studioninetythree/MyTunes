package za.ac.cput.MyTunes.services;

import za.ac.cput.MyTunes.domain.Customer;
import za.ac.cput.MyTunes.domain.Orders;

import java.util.List;

public interface ICustomerService extends IServices<Customer, Long> {

    List<Orders> getOrders(Long id);

}
