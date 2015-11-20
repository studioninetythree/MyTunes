package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.OrdersFactory;

import java.math.BigDecimal;

public class OrdersTest {

    @Test
    public void testCreate() {
        Orders order = OrdersFactory.createOrders("Confirmed", "2015-11-10", "2015-11-12", new BigDecimal(189), null);
        Assert.assertEquals(order.getOrderStatus(), "Confirmed");
        Assert.assertEquals(order.getDateOrderPaid(), "2015-11-12");
    }

    @Test
    public void testUpdate() {
        Orders order = OrdersFactory.createOrders("Confirmed", "2015-11-10", "2015-11-12", new BigDecimal(189), null);
        Orders orderCopy = new Orders.Builder(order.getOrderStatus()).copy(order).dateOrderPaid("2015-11-15").build();
        Assert.assertEquals(orderCopy.getOrderStatus(), "Confirmed");
        Assert.assertEquals(orderCopy.getDateOrderPaid(), "2015-11-15");
    }

}
