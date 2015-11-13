package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.domain.Orders;
import za.ac.cput.MyTunes.repository.OrdersRepository;
import za.ac.cput.MyTunes.services.IOrdersService;

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
    public Orders findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Orders create(Orders order) {
        return repository.save(order);
    }

    @Override
    public Orders edit(Orders order) {
        return repository.save(order);
    }

    @Override
    public void delete(Orders order) {
        repository.delete(order);
    }

    @Override
    public List<Orders> findAll() {
        List<Orders> allOrders = new ArrayList<Orders>();

        Iterable<Orders> orders = repository.findAll();
        for (Orders order : orders) {
            allOrders.add(order);
        }
        return allOrders;
    }

}
