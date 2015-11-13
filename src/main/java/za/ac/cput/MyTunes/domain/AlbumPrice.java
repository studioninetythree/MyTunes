package za.ac.cput.MyTunes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class AlbumPrice implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dateFrom;
    private BigDecimal productPrice;

    private AlbumPrice() {}

    public AlbumPrice(Builder builder) {
        this.id = builder.id;
        this.dateFrom = builder.dateFrom;
        this.productPrice = builder.productPrice;
    }

    public Long getId() {
        return id;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public static class Builder {

        private Long id;
        private String dateFrom;
        private BigDecimal productPrice;

        public Builder(BigDecimal productPrice) {
            this.productPrice = productPrice;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder dateFrom(String dateFrom) {
            this.dateFrom = dateFrom;
            return this;
        }

        public Builder productPrice(BigDecimal productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder copy(AlbumPrice albumPrice) {
            this.id = albumPrice.id;
            this.dateFrom = albumPrice.dateFrom;
            this.productPrice = albumPrice.productPrice;
            return this;
        }

        public AlbumPrice build() {
            return new AlbumPrice(this);
        }

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AlbumPrice{" +
                "id=" + id +
                ", dateFrom='" + dateFrom + '\'' +
                ", albumPrice=" + productPrice +
                '}';
    }

}
