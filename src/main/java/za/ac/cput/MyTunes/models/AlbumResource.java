package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MyTunes.domain.AlbumPrice;
import za.ac.cput.MyTunes.domain.OrderAlbum;

import java.math.BigDecimal;
import java.util.List;

public class AlbumResource extends ResourceSupport {

    private Long resourceId;
    private String resourceName;
    private String resourceArtist;
    private String resourceDescription;
    private BigDecimal resourcePrice;
    private List<OrderAlbum> resourceOrderAlbumList;
    private List<AlbumPrice> resourceAlbumPriceList;

    private AlbumResource() {}

    public AlbumResource(Builder builder) {
        this.resourceId = builder.resourceId;
        this.resourceName = builder.resourceName;
        this.resourceArtist = builder.resourceArtist;
        this.resourcePrice = builder.resourcePrice;
        this.resourceDescription = builder.resourceDescription;
        this.resourceOrderAlbumList = builder.resourceOrderAlbumList;
        this.resourceAlbumPriceList = builder.resourceAlbumPriceList;
    }

    public Long getResourceIdId() {
        return resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getArtist() {
        return resourceArtist;
    }

    public BigDecimal getPrice() {
        return resourcePrice;
    }

    public String getDescription() {
        return resourceDescription;
    }

    public List<OrderAlbum> getOrderAlbumList() {
        return resourceOrderAlbumList;
    }

    public List<AlbumPrice> getAlbumPriceList() {
        return resourceAlbumPriceList;
    }

    public static class Builder {

        private Long resourceId;
        private String resourceName;
        private String resourceArtist;
        private String resourceDescription;
        private BigDecimal resourcePrice;
        private List<OrderAlbum> resourceOrderAlbumList;
        private List<AlbumPrice> resourceAlbumPriceList;

        public Builder(String resourceName) {
            this.resourceName = resourceName;
        }

        public Builder id(Long id) {
            this.resourceId = id;
            return this;
        }

        public Builder name(String name) {
            this.resourceName = name;
            return this;
        }

        public Builder artist(String artist) {
            this.resourceArtist = artist;
            return this;
        }

        public Builder description(String description) {
            this.resourceDescription = description;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.resourcePrice = price;
            return this;
        }

        public Builder orderAlbumList(List<OrderAlbum> orderAlbumList) {
            this.resourceOrderAlbumList = orderAlbumList;
            return this;
        }

        public Builder productPriceList(List<AlbumPrice> albumPriceList) {
            this.resourceAlbumPriceList = albumPriceList;
            return this;
        }

        public Builder copy(AlbumResource album) {
            this.resourceId = album.resourceId;
            this.resourceName = album.resourceName;
            this.resourceArtist = album.resourceArtist;
            this.resourceDescription = album.resourceDescription;
            this.resourcePrice = album.resourcePrice;
            this.resourceOrderAlbumList = album.resourceOrderAlbumList;
            this.resourceAlbumPriceList = album.resourceAlbumPriceList;
            return this;
        }

        public AlbumResource build() {
            return new AlbumResource(this);
        }

    }

    @Override
    public int hashCode() {
        return resourceId != null ? resourceId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Album{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceArtist='" + resourceArtist + '\'' +
                ", resourceDescription=" + resourceDescription +
                ", resourcePrice=" + resourcePrice +
                ", resourceOrderAlbumList=" + resourceOrderAlbumList +
                ", resourceAlbumPriceList=" + getAlbumPriceList() +
                '}';
    }

}
