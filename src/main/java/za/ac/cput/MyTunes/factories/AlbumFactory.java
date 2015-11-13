package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.Album;
import za.ac.cput.MyTunes.domain.OrderAlbum;
import za.ac.cput.MyTunes.domain.AlbumPrice;

import java.math.BigDecimal;
import java.util.List;

public class AlbumFactory {

    public static Album createAlbum(String name, String artist, BigDecimal price, String description, List<OrderAlbum> orderAlbumList, List<AlbumPrice> albumPriceList) {
        return new Album.Builder(name).artist(artist).description(description).price(price).orderAlbumList(orderAlbumList).productPriceList(albumPriceList).build();
    }

}
