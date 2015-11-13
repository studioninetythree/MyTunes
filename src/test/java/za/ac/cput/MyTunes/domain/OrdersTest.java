package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.OrdersFactory;

import java.math.BigDecimal;

public class OrdersTest {

    @Test
    public void testCreate() {
        Orders order = OrdersFactory.createOrders("Confirmed", "2015-10-10", "2015-10-10", new BigDecimal(200), null);
        Assert.assertEquals(order.getOrderStatus(), "Confirmed");
        Assert.assertEquals(order.getDateOrderPaid(), "2015-10-10");
    }

    @Test
    public void testUpdate() {
        Orders order = OrdersFactory.createOrders("Confirmed", "2015-10-10", "2015-10-10", new BigDecimal(200), null);
        Orders orderCopy = new Orders.Builder(order.getOrderStatus()).copy(order).dateOrderPaid("2015-10-15").build();
        Assert.assertEquals(orderCopy.getOrderStatus(), "Confirmed");
        Assert.assertEquals(orderCopy.getDateOrderPaid(), "2015-10-15");
    }

}
