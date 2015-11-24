package za.ac.cput.MyTunes.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.domain.Order;
import za.ac.cput.MyTunes.factories.OrdersFactory;

import java.math.BigDecimal;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OrderCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    OrdersRepository repository;

    @Test
    public void testCreate() throws Exception {
        repository.deleteAll();
        Order order = OrdersFactory.createOrders("Confirmed", "2015-112-24", "2015-12-24", new BigDecimal(149), null);
        repository.save(order);
        id = order.getId();
        Assert.assertNotNull(order.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Order order = repository.findOne(id);
        Assert.assertEquals(order.getOrderStatus(), "Confirmed");
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Order order = repository.findOne(id);
        Order newOrder = new Order.Builder(order.getOrderStatus()).copy(order).dateOrderPaid("2015-12-26").build();
        repository.save(newOrder);
        Order updatedOrder = repository.findOne(id);
        Assert.assertEquals(updatedOrder.getDateOrderPaid(), "2015-12-26");
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Order order = repository.findOne(id);
        repository.delete(order);
        Order newOrder = repository.findOne(id);
        Assert.assertNull(newOrder);
    }

}
