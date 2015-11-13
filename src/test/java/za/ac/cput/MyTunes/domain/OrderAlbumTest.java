package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.OrderProductFactory;

public class OrderAlbumTest {

    @Test
    public void testCreate() {
        OrderAlbum orderAlbum = OrderProductFactory.createOrderAlbum(20);
        Assert.assertEquals(orderAlbum.getQuantity(), 20);
    }

    @Test
    public void testUpdate() {
        OrderAlbum orderAlbum = OrderProductFactory.createOrderAlbum(20);
        OrderAlbum orderAlbumCopy = new OrderAlbum.Builder(15).build();
        Assert.assertEquals(orderAlbumCopy.getQuantity(), 15);
    }

}
