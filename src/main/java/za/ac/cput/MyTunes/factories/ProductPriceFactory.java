package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.AlbumPrice;

import java.math.BigDecimal;

public class ProductPriceFactory {

    public static AlbumPrice createProductPrice(String dateFrom, BigDecimal productPrice) {
        return new AlbumPrice.Builder(productPrice).dateFrom(dateFrom).build();
    }

}
