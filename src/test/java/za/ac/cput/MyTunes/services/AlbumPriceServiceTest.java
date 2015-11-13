package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.ProductPriceFactory;
import za.ac.cput.MyTunes.domain.AlbumPrice;
import za.ac.cput.MyTunes.repository.ProductPriceRepository;

import java.math.BigDecimal;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AlbumPriceServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IAlbumPriceService service;
    private Long id;
    @Autowired
    private ProductPriceRepository repository;

    @Test
    public void create() throws Exception {
        repository.deleteAll();
        AlbumPrice albumPrice = ProductPriceFactory.createProductPrice("2015-09-23", new BigDecimal(11000));
        service.create(albumPrice);
        id = albumPrice.getId();
        Assert.assertNotNull(albumPrice);
    }

    @Test(dependsOnMethods = "create")
    public void testGetProductPrice() throws Exception {
        AlbumPrice albumPrice = service.findById(id);
        Assert.assertEquals(albumPrice.getDateFrom(), "2015-09-23");
    }

    @Test(dependsOnMethods = "testGetProductPrice")
    public void testGetProductPrices() throws Exception {
        List<AlbumPrice> albumPriceList = service.findAll();
        Assert.assertEquals(albumPriceList.size(), 1);
    }

    @Test(dependsOnMethods = "testGetProductPrices")
    public void testEditProductPrice() throws Exception {
        AlbumPrice albumPrice = repository.findOne(id);
        AlbumPrice updatedAlbumPrice = new AlbumPrice.Builder(albumPrice.getProductPrice()).copy(albumPrice).dateFrom("2015-09-25").build();
        service.edit(updatedAlbumPrice);
        AlbumPrice newAlbumPrice = repository.findOne(id);
        Assert.assertEquals(newAlbumPrice.getDateFrom(), "2015-09-25");
    }

    @Test(dependsOnMethods = "testEditProductPrice")
    public void testDeleteProductPrice() throws Exception {
        AlbumPrice albumPrice = repository.findOne(id);
        service.delete(albumPrice);
        AlbumPrice newAlbumPrice = repository.findOne(id);
        Assert.assertNull(newAlbumPrice);
    }

}
