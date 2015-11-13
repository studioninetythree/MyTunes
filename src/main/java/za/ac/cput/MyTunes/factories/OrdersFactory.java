package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.domain.Orders;

import java.math.BigDecimal;
import java.util.List;

public class OrdersFactory {

    public static Orders createOrders(String orderStatus, String dateOrderPlaced, String dateOrderPaid, BigDecimal totalOrderPrice, List<OrderAlbum> orderAlbumList) {
        return new Orders.Builder(orderStatus).dateOrderPlaced(dateOrderPlaced).dateOrderPaid(dateOrderPaid).totalOrderPrice(totalOrderPrice).orderProductList(orderAlbumList).build();
    }

}
