package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.OrderProductFactory;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.repository.OrderProductRepository;

import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OrderAlbumServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IOrderAlbumService service;
    private Long id;
    @Autowired
    private OrderProductRepository repository;

    @Test
    public void create() throws Exception {
        repository.deleteAll();
        OrderAlbum orderAlbum = OrderProductFactory.createOrderAlbum(20);
        service.create(orderAlbum);
        id = orderAlbum.getId();
        Assert.assertNotNull(orderAlbum);
    }

    @Test(dependsOnMethods = "create")
    public void testGetOrderProduct() throws Exception {
        OrderAlbum orderAlbum = service.findById(id);
        Assert.assertEquals(orderAlbum.getQuantity(), 20);
    }

    @Test(dependsOnMethods = "testGetOrderProduct")
    public void testGetOrderProducts() throws Exception {
        List<OrderAlbum> orderAlbumList = service.findAll();
        Assert.assertEquals(orderAlbumList.size(), 1);
    }

    @Test(dependsOnMethods = "testGetOrderProducts")
    public void testEditOrderProduct() throws Exception {
        OrderAlbum orderAlbum = repository.findOne(id);
        OrderAlbum updatedOrderAlbum = new OrderAlbum.Builder(orderAlbum.getQuantity()).copy(orderAlbum).quantity(15).build();
        service.edit(updatedOrderAlbum);
        OrderAlbum newOrderAlbum = repository.findOne(id);
        Assert.assertEquals(newOrderAlbum.getQuantity(), 15);
    }

    @Test(dependsOnMethods = "testEditOrderProduct")
    public void testDeleteCustomer() throws Exception {
        OrderAlbum orderAlbum = repository.findOne(id);
        service.delete(orderAlbum);
        OrderAlbum newOrderAlbum = repository.findOne(id);
        Assert.assertNull(newOrderAlbum);
    }

}
