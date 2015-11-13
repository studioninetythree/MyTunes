package za.ac.cput.MyTunes.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String artist;
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<OrderAlbum> orderAlbumList;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<AlbumPrice> albumPriceList;

    private Album() {}

    public Album(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.artist = builder.artist;
        this.price = builder.price;
        this.description = builder.description;
        this.orderAlbumList = builder.orderAlbumList;
        this.albumPriceList = builder.albumPriceList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<OrderAlbum> getOrderAlbumList() {
        return orderAlbumList;
    }

    public List<AlbumPrice> getAlbumPriceList() {
        return albumPriceList;
    }

    public static class Builder {

        private Long id;
        private String name;
        private String artist;
        private String description;
        private BigDecimal price;
        private List<OrderAlbum> orderAlbumList;
        private List<AlbumPrice> albumPriceList;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder artist(String artist) {
            this.artist = artist;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder orderAlbumList(List<OrderAlbum> orderAlbumList) {
            this.orderAlbumList = orderAlbumList;
            return this;
        }

        public Builder productPriceList(List<AlbumPrice> albumPriceList) {
            this.albumPriceList = albumPriceList;
            return this;
        }

        public Builder copy(Album album) {
            this.id = album.id;
            this.name = album.name;
            this.artist = album.artist;
            this.description = album.description;
            this.price = album.price;
            this.orderAlbumList = album.orderAlbumList;
            this.albumPriceList = album.albumPriceList;
            return this;
        }

        public Album build() {
            return new Album(this);
        }

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", description=" + description +
                ", price=" + price +
                ", orderAlbumList=" + orderAlbumList +
                ", albumPriceList=" + albumPriceList +
                '}';
    }

}
