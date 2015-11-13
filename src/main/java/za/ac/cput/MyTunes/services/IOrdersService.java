package za.ac.cput.MyTunes.services;

import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.domain.Orders;

import java.util.List;

public interface IOrdersService extends IServices<Orders, Long> {

    List<OrderAlbum> getOrderProducts(Long id);

}
