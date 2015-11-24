package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MyTunes.domain.OrderAlbum;

import java.math.BigDecimal;
import java.util.List;

public class OrderResource extends ResourceSupport {

    private Long resourceId;
    private String resourceOrderStatus;
    private String resourceDateOrderPlaced;
    private String resourceDateOrderPaid;
    private BigDecimal resourceTotalOrderPrice;
    private List<OrderAlbum> resourceOrderAlbumList;

    private OrderResource(){}

    public OrderResource(Builder builder) {
        this.resourceId = builder.resourceId;
        this.resourceOrderStatus = builder.resourceOrderStatus;
        this.resourceDateOrderPlaced = builder.resourceDateOrderPlaced;
        this.resourceDateOrderPaid = builder.resourceDateOrderPaid;
        this.resourceTotalOrderPrice = builder.resourceTotalOrderPrice;
        this.resourceOrderAlbumList = builder.resourceOrderAlbumList;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public String getResourceOrderStatus() {
        return resourceOrderStatus;
    }

    public String getResourceDateOrderPlaced() {
        return resourceDateOrderPlaced;
    }

    public String getResourceDateOrderPaid() {
        return resourceDateOrderPaid;
    }

    public BigDecimal getResourceTotalOrderPrice() {
        return resourceTotalOrderPrice;
    }

    public List<OrderAlbum> getResourceOrderAlbumList() {
        return resourceOrderAlbumList;
    }

    public static class Builder {

        private Long resourceId;
        private String resourceOrderStatus;
        private String resourceDateOrderPlaced;
        private String resourceDateOrderPaid;
        private BigDecimal resourceTotalOrderPrice;
        private List<OrderAlbum> resourceOrderAlbumList;

        public Builder(String resourceOrderStatus) {
            this.resourceOrderStatus = resourceOrderStatus;
        }

        public Builder id(Long id) {
            this.resourceId = id;
            return this;
        }

        public Builder orderStatus(String orderStatus) {
            this.resourceOrderStatus = orderStatus;
            return this;
        }

        public Builder dateOrderPlaced(String dateOrderPlaced) {
            this.resourceDateOrderPlaced = dateOrderPlaced;
            return this;
        }

        public Builder dateOrderPaid(String dateOrderPaid) {
            this.resourceDateOrderPaid = dateOrderPaid;
            return this;
        }

        public Builder totalOrderPrice(BigDecimal totalOrderPrice) {
            this.resourceTotalOrderPrice = totalOrderPrice;
            return this;
        }

        public Builder orderProductList(List<OrderAlbum> orderAlbumList) {
            this.resourceOrderAlbumList = orderAlbumList;
            return this;
        }

        public Builder copy(OrderResource order) {
            this.resourceId = order.resourceId;
            this.resourceOrderStatus = order.resourceOrderStatus;
            this.resourceDateOrderPlaced = order.resourceDateOrderPlaced;
            this.resourceDateOrderPaid = order.resourceDateOrderPaid;
            this.resourceTotalOrderPrice = order.resourceTotalOrderPrice;
            this.resourceOrderAlbumList = order.resourceOrderAlbumList;
            return this;
        }

        public OrderResource build() {
            return new OrderResource(this);
        }

    }

    @Override
    public int hashCode() {
        return resourceId != null ? resourceId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrderResource{" +
                "resourceId=" + resourceId +
                ", resourceOrderStatus='" + resourceOrderStatus + '\'' +
                ", resourceDateOrderPlaced='" + resourceDateOrderPlaced + '\'' +
                ", resourceDateOrderPaid='" + resourceDateOrderPaid + '\'' +
                ", resourceTotalOrderPrice=" + resourceTotalOrderPrice +
                ", resourceOrderAlbumList=" + resourceOrderAlbumList +
                '}';
    }
}
