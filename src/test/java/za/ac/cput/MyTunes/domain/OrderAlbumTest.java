package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.OrderProductFactory;

public class OrderAlbumTest {

    @Test
    public void testCreate() {
        OrderAlbum orderAlbum = OrderProductFactory.createOrderAlbum(22);
        Assert.assertEquals(orderAlbum.getQuantity(), 22);
    }

    @Test
    public void testUpdate() {
        OrderAlbum orderAlbum = OrderProductFactory.createOrderAlbum(56);
        OrderAlbum orderAlbumCopy = new OrderAlbum.Builder(2).build();
        Assert.assertEquals(orderAlbumCopy.getQuantity(), 2);
    }

}
