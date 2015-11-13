package za.ac.cput.MyTunes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class OrderAlbum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    private OrderAlbum() {}

    public OrderAlbum(Builder builder) {
        this.id = builder.id;
        this.quantity = builder.quantity;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder {

        private Long id;
        private int quantity;

        public Builder(int quantity) {
            this.quantity = quantity;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(OrderAlbum orderAlbum) {
            this.id = orderAlbum.id;
            this.quantity = orderAlbum.quantity;
            return this;
        }

        public OrderAlbum build() {
            return new OrderAlbum(this);
        }

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "OrderAlbum{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }

}
