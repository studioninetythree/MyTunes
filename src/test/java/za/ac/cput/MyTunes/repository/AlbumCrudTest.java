package za.ac.cput.MyTunes.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.MyTunes.App;
import za.ac.cput.MyTunes.factories.AlbumFactory;
import za.ac.cput.MyTunes.domain.Album;

import java.math.BigDecimal;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class AlbumCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    AlbumRepository repository;

    @Test
    public void testCreate() throws Exception {
        repository.deleteAll();
        Album album = AlbumFactory.createAlbum("Helios", "The Fray", new BigDecimal(299), "Cool Indie Rock Album", null, null);
        repository.save(album);
        id = album.getId();
        Assert.assertNotNull(album.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        Album album = repository.findOne(id);
        Assert.assertEquals(album.getName(), "Helios");
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Album album = repository.findOne(id);
        Album newAlbum = new Album.Builder(album.getName()).copy(album).build();
        repository.save(newAlbum);
        Album updatedAlbum = repository.findOne(id);
        Assert.assertEquals(updatedAlbum.getArtist(), "The Fray");
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Album album = repository.findOne(id);
        repository.delete(album);
        Album newAlbum = repository.findOne(id);
        Assert.assertNull(newAlbum);
    }

}
