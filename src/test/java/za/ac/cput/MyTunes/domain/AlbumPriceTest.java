package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.ProductPriceFactory;

import java.math.BigDecimal;

public class AlbumPriceTest {

    @Test
    public void testCreate() {
        AlbumPrice albumPrice = ProductPriceFactory.createProductPrice("2015-08-22", new BigDecimal(11000));
        Assert.assertEquals(albumPrice.getDateFrom(), "2015-08-22");
        Assert.assertEquals(albumPrice.getProductPrice(), new BigDecimal(11000));
    }

    @Test
    public void testUpdate() {
        AlbumPrice albumPrice = ProductPriceFactory.createProductPrice("2015-08-22", new BigDecimal(11000));
        AlbumPrice albumPriceCopy = new AlbumPrice.Builder(albumPrice.getProductPrice()).copy(albumPrice).productPrice(new BigDecimal(8000)).build();
        Assert.assertEquals(albumPriceCopy.getDateFrom(), "2015-08-22");
        Assert.assertEquals(albumPriceCopy.getProductPrice(), new BigDecimal(8000));
    }

}
