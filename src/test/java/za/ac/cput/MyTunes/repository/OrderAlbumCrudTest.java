package za.ac.cput.MyTunes.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.OrderProductFactory;
import za.ac.cput.MyTunes.domain.OrderAlbum;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OrderAlbumCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    OrderProductRepository repository;

    @Test
    public void testCreate() throws Exception {
        repository.deleteAll();
        OrderAlbum orderAlbum = OrderProductFactory.createOrderAlbum(20);
        repository.save(orderAlbum);
        id = orderAlbum.getId();
        Assert.assertNotNull(orderAlbum.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        OrderAlbum orderAlbum = repository.findOne(id);
        Assert.assertEquals(orderAlbum.getQuantity(), 20);
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        OrderAlbum orderAlbum = repository.findOne(id);
        OrderAlbum newOrderAlbum = new OrderAlbum.Builder(orderAlbum.getQuantity()).copy(orderAlbum).quantity(15).build();
        repository.save(newOrderAlbum);
        OrderAlbum updatedOrderAlbum = repository.findOne(id);
        Assert.assertEquals(updatedOrderAlbum.getQuantity(), 15);
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        OrderAlbum orderAlbum = repository.findOne(id);
        repository.delete(orderAlbum);
        OrderAlbum newOrderAlbum = repository.findOne(id);
        Assert.assertNull(newOrderAlbum);
    }

}
