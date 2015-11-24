package za.ac.cput.MyTunes.services;

import za.ac.cput.MyTunes.domain.Order;
import za.ac.cput.MyTunes.domain.OrderAlbum;

import java.util.List;

public interface IOrdersService extends IServices<Order, Long> {

    List<OrderAlbum> getOrderProducts(Long id);

}
