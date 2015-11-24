package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;

public class OrderAlbumResource extends ResourceSupport{

    private Long resourceId;
    private int resourceQuantity;

    private OrderAlbumResource() {}

    public OrderAlbumResource(Builder builder) {
        this.resourceId = builder.resourceId;
        this.resourceQuantity = builder.resourceQuantity;
    }

    public Long getResourceeId() {
        return resourceId;
    }

    public int getResourceQuantity() {
        return resourceQuantity;
    }

    public static class Builder {

        private Long resourceId;
        private int resourceQuantity;

        public Builder(int resourceQuantity) {
            this.resourceQuantity = resourceQuantity;
        }

        public Builder id(Long id) {
            this.resourceId = id;
            return this;
        }

        public Builder quantity(int quantity) {
            this.resourceQuantity = quantity;
            return this;
        }

        public Builder copy(OrderAlbumResource orderAlbum) {
            this.resourceId = orderAlbum.resourceId;
            this.resourceQuantity = orderAlbum.resourceQuantity;
            return this;
        }

        public OrderAlbumResource build() {
            return new OrderAlbumResource(this);
        }

    }

    @Override
    public int hashCode() {
        return resourceId != null ? resourceId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrderAlbum{" +
                "resourceId=" + resourceId +
                ", resourceQuantity=" + resourceQuantity +
                '}';
    }
}
