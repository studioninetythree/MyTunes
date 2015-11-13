package za.ac.cput.MyTunes.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.ProductPriceFactory;
import za.ac.cput.MyTunes.domain.AlbumPrice;

import java.math.BigDecimal;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AlbumPriceCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    ProductPriceRepository repository;

    @Test
    public void testCreate() throws Exception {
        repository.deleteAll();
        AlbumPrice albumPrice = ProductPriceFactory.createProductPrice("2015-09-23", new BigDecimal(11000));
        repository.save(albumPrice);
        id = albumPrice.getId();
        Assert.assertNotNull(albumPrice.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        AlbumPrice albumPrice = repository.findOne(id);
        Assert.assertEquals(albumPrice.getDateFrom(), "2015-09-23");
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        AlbumPrice albumPrice = repository.findOne(id);
        AlbumPrice newAlbumPrice = new AlbumPrice.Builder(albumPrice.getProductPrice()).copy(albumPrice).dateFrom("2015-09-25").build();
        repository.save(newAlbumPrice);
        AlbumPrice updatedAlbumPrice = repository.findOne(id);
        Assert.assertEquals(updatedAlbumPrice.getDateFrom(), "2015-09-25");
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        AlbumPrice albumPrice = repository.findOne(id);
        repository.delete(albumPrice);
        AlbumPrice newAlbumPrice = repository.findOne(id);
        Assert.assertNull(newAlbumPrice);
    }

}
