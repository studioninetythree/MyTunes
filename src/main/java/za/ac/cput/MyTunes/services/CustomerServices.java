package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MyTunes.domain.Customer;
import za.ac.cput.MyTunes.domain.Order;
import za.ac.cput.MyTunes.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServices implements ICustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public List<Order> getOrders(Long id) {
        return repository.findOne(id).getOrderList();
    }

    @Override
    public Customer findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer edit(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        repository.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> allCustomers = new ArrayList<Customer>();

        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            allCustomers.add(customer);
        }
        return allCustomers;
    }

}
