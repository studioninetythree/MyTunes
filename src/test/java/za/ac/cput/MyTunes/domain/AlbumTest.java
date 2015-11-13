package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.AlbumFactory;

import java.math.BigDecimal;

public class AlbumTest {

    @Test
    public void testCreate() {
        Album album = AlbumFactory.createAlbum("Helios", "The Fray", new BigDecimal(299), "Cool Indie Rock Album", null, null);
        Assert.assertEquals(album.getName(), "Note 5");
        Assert.assertEquals(album.getArtist(), "Samsung");
    }

    @Test
    public void testUpdate() {
        Album album = AlbumFactory.createAlbum("Helios", "The Fray", new BigDecimal(299), "Cool Indie Rock Album", null, null);
        Album albumCopy = new Album.Builder(album.getName()).copy(album).build();
        Assert.assertEquals(albumCopy.getName(), "Note 5");
    }

}
