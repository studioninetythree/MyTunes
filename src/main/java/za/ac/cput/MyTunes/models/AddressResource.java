package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;

public class AddressResource extends ResourceSupport {
    private String resourceAddress;
    private String resourceCity;
    private String resourceCountry;
    private String resourceZipCode;

    private AddressResource(){}

    public AddressResource(Builder builder) {
        this.resourceAddress = builder.resourceAddress;
        this.resourceCity = builder.resourceCity;
        this.resourceCountry = builder.resourceCountry;
        this.resourceZipCode = builder.resourceZipCode;
    }

    public String getResourceAddress() {
        return resourceAddress;
    }

    public String getResourceCity() {
        return resourceCity;
    }

    public String getResourceCountry() {
        return resourceCountry;
    }

    public String getResourceZipCode() {
        return resourceZipCode;
    }

    public static class Builder {

        private String resourceAddress;
        private String resourceCity;
        private String resourceCountry;
        private String resourceZipCode;

        public Builder(String resourceAddress) {
            this.resourceAddress = resourceAddress;
        }

        public Builder address(String address) {
            this.resourceAddress = address;
            return this;
        }

        public Builder city(String city) {
            this.resourceCity = city;
            return this;
        }

        public Builder country(String country) {
            this.resourceCountry = country;
            return this;
        }

        public Builder zipCode(String zipCode) {
            this.resourceZipCode = zipCode;
            return this;
        }

        public Builder copy(AddressResource address) {
            this.resourceAddress = address.resourceAddress;
            this.resourceCity = address.resourceCity;
            this.resourceCountry = address.resourceCountry;
            this.resourceZipCode = address.resourceZipCode;
            return this;
        }

        public AddressResource build() {
            return new AddressResource(this);
        }

    }

    @Override
    public String toString() {
        return "AddressResource{" +
                "resourceAddress='" + resourceAddress + '\'' +
                ", resourceCity='" + resourceCity + '\'' +
                ", resourceCountry='" + resourceCountry + '\'' +
                ", resourceZipCode='" + resourceZipCode + '\'' +
                '}';
    }
}
