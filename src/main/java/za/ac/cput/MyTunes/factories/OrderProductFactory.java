package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.OrderAlbum;

public class OrderProductFactory {

    public static OrderAlbum createOrderAlbum(int quantity) {
        return new OrderAlbum.Builder(quantity).build();
    }

}
