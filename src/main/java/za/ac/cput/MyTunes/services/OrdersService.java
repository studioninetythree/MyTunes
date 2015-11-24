package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MyTunes.domain.Order;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.repository.OrdersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService implements IOrdersService {

    @Autowired
    OrdersRepository repository;

    @Override
    public List<OrderAlbum> getOrderProducts(Long id) {
        return repository.findOne(id).getOrderAlbumList();
    }

    @Override
    public Order findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }

    @Override
    public Order edit(Order order) {
        return repository.save(order);
    }

    @Override
    public void delete(Order order) {
        repository.delete(order);
    }

    @Override
    public List<Order> findAll() {
        List<Order> allOrders = new ArrayList<Order>();

        Iterable<Order> orders = repository.findAll();
        for (Order order : orders) {
            allOrders.add(order);
        }
        return allOrders;
    }

}
