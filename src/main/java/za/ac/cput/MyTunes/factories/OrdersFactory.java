package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public class OrdersFactory {

    public static Order createOrders(String orderStatus, String dateOrderPlaced, String dateOrderPaid, BigDecimal totalOrderPrice, List<OrderAlbum> orderAlbumList) {
        return new Order.Builder(orderStatus).dateOrderPlaced(dateOrderPlaced).dateOrderPaid(dateOrderPaid).totalOrderPrice(totalOrderPrice).orderProductList(orderAlbumList).build();
    }

}
