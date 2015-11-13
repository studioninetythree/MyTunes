package za.ac.cput.MyTunes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.AlbumFactory;
import za.ac.cput.MyTunes.domain.Album;
import za.ac.cput.MyTunes.repository.AlbumRepository;

import java.math.BigDecimal;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AlbumServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private IAlbumService service;
    private Long id;
    @Autowired
    private AlbumRepository repository;

    @Test
    public void create() throws Exception {
        repository.deleteAll();
        Album album = AlbumFactory.createAlbum("Helios", "The Fray", new BigDecimal(299), "Cool Indie Rock Album", null, null);
        service.create(album);
        id = album.getId();
        Assert.assertNotNull(album);
    }

    @Test(dependsOnMethods = "create")
    public void testGetProduct() throws Exception {
        Album album = service.findById(id);
        Assert.assertEquals(album.getName(), "Note 5");
    }

    @Test(dependsOnMethods = "testGetProduct")
    public void testGetProducts() throws Exception {
        List<Album> albumList = service.findAll();
        Assert.assertEquals(albumList.size(), 1);
    }

    @Test(dependsOnMethods = "testGetProducts")
    public void testEditProduct() throws Exception {
        Album album = repository.findOne(id);
        Album updatedAlbum = new Album.Builder(album.getName()).copy(album).build();
        service.edit(updatedAlbum);
        Album newAlbum = repository.findOne(id);
        Assert.assertEquals(newAlbum.getDescription(), "Cool");
    }

    @Test(dependsOnMethods = "testEditProduct")
    public void testDeleteProduct() throws Exception {
        Album album = repository.findOne(id);
        service.delete(album);
        Album newAlbum = repository.findOne(id);
        Assert.assertNull(newAlbum);
    }

}
