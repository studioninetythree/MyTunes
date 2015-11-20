package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.OrderProductFactory;
import za.ac.cput.MyTunes.factories.OrdersFactory;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.domain.Orders;
import za.ac.cput.MyTunes.repository.OrdersRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OrdersServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IOrdersService service;
    private Long id;
    @Autowired
    private OrdersRepository repository;

    @Test
    public void create() throws Exception {
        repository.deleteAll();
        OrderAlbum orderAlbum = OrderProductFactory.createOrderAlbum(20);
        List<OrderAlbum> orderAlbumList = new ArrayList<OrderAlbum>();
        orderAlbumList.add(orderAlbum);
        Orders order = OrdersFactory.createOrders("Confirmed", "2015-11-26", "2015-11-26", new BigDecimal(165), orderAlbumList);
        service.create(order);
        id = order.getId();
        Assert.assertNotNull(order);
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrder() throws Exception {
        Orders order = service.findById(id);
        Assert.assertEquals(order.getOrderStatus(), "Confirmed");
    }

    @Test(dependsOnMethods = "testGetOrder")
    public void testGetOrders() throws Exception {
        List<Orders> ordersList = service.findAll();
        Assert.assertEquals(ordersList.size(), 1);
    }

    @Test(dependsOnMethods = "testGetOrders")
    public void testGetOrderProducts() throws Exception {
        List<OrderAlbum> orderAlbumList = service.findById(id).getOrderAlbumList();
        Assert.assertEquals(orderAlbumList.size(), 1);
    }

    @Test(dependsOnMethods = "testGetOrders")
    public void testEditOrder() throws Exception {
        Orders order = repository.findOne(id);
        Orders updatedOrder = new Orders.Builder(order.getOrderStatus()).copy(order).dateOrderPaid("2015-11-28").build();
        service.edit(updatedOrder);
        Orders newOrder = repository.findOne(id);
        Assert.assertEquals(newOrder.getDateOrderPaid(), "2015-11-28");
    }

    @Test(dependsOnMethods = "testEditOrder")
    public void testDeleteCustomer() throws Exception {
        Orders order = repository.findOne(id);
        service.delete(order);
        Orders newOrder = repository.findOne(id);
        Assert.assertNull(newOrder);
    }

}
