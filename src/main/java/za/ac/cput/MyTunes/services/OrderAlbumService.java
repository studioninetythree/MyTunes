package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.repository.OrderProductRepository;
import za.ac.cput.MyTunes.services.IOrderAlbumService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderAlbumService implements IOrderAlbumService {

    @Autowired
    OrderProductRepository repository;


    @Override
    public OrderAlbum findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public OrderAlbum create(OrderAlbum orderAlbum) {
        return repository.save(orderAlbum);
    }

    @Override
    public OrderAlbum edit(OrderAlbum orderAlbum) {
        return repository.save(orderAlbum);
    }

    @Override
    public void delete(OrderAlbum orderAlbum) {
        repository.delete(orderAlbum);
    }

    @Override
    public List<OrderAlbum> findAll() {
        List<OrderAlbum> allOrderAlbums = new ArrayList<OrderAlbum>();

        Iterable<OrderAlbum> orderProducts = repository.findAll();
        for (OrderAlbum orderAlbum : orderProducts) {
            allOrderAlbums.add(orderAlbum);
        }
        return allOrderAlbums;
    }
}
