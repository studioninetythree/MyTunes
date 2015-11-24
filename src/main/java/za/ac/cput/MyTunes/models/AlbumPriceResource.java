package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;

import java.math.BigDecimal;

public class AlbumPriceResource extends ResourceSupport {

    private Long resourceId;
    private String resourceDateFrom;
    private BigDecimal resourceProductPrice;

    private AlbumPriceResource() {}

    public AlbumPriceResource(Builder builder) {
        this.resourceId = builder.resourceId;
        this.resourceDateFrom = builder.resourceDateFrom;
        this.resourceProductPrice = builder.resourceProductPrice;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public String getResourceDateFrom() {
        return resourceDateFrom;
    }

    public BigDecimal getResourceProductPrice() {
        return resourceProductPrice;
    }

    public static class Builder {

        private Long resourceId;
        private String resourceDateFrom;
        private BigDecimal resourceProductPrice;

        public Builder(BigDecimal resourceProductPrice) {
            this.resourceProductPrice = resourceProductPrice;
        }

        public Builder id(Long id) {
            this.resourceId = id;
            return this;
        }

        public Builder dateFrom(String dateFrom) {
            this.resourceDateFrom = dateFrom;
            return this;
        }

        public Builder productPrice(BigDecimal productPrice) {
            this.resourceProductPrice = productPrice;
            return this;
        }

        public Builder copy(AlbumPriceResource albumPrice) {
            this.resourceId = albumPrice.resourceId;
            this.resourceDateFrom = albumPrice.resourceDateFrom;
            this.resourceProductPrice = albumPrice.resourceProductPrice;
            return this;
        }

        public AlbumPriceResource build() {
            return new AlbumPriceResource(this);
        }

    }

    @Override
    public int hashCode() {
        return resourceId != null ? resourceId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AlbumPrice{" +
                "resourceId=" + resourceId +
                ", resourceDateFrom='" + resourceDateFrom + '\'' +
                ", albumPrice=" + resourceProductPrice +
                '}';
    }
}
