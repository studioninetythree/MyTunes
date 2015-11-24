package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.MyTunes.domain.Address;
import za.ac.cput.MyTunes.domain.Contact;
import za.ac.cput.MyTunes.domain.Name;
import za.ac.cput.MyTunes.domain.Order;

import java.util.List;

public class CustomerResource extends ResourceSupport {

    private Long id;

    private Name resourceName;
    private String resourceSex;
    private String resourceDateOfBirth;
    private Contact resourceContact;
    private Address resourceAddress;
    private List<Order> resourceOrderList;

    private CustomerResource() {}

    public CustomerResource(Builder builder) {
        this.id = builder.resourceId;
        this.resourceName = builder.resourceName;
        this.resourceSex = builder.resourceSex;
        this.resourceDateOfBirth = builder.resourceDateOfBirth;
        this.resourceContact = builder.resourceContact;
        this.resourceAddress = builder.resourceAddress;
        this.resourceOrderList = builder.resourceOrderList;
    }

    public Long getResourceId() {
        return id;
    }

    public Name getResourceName() {
        return resourceName;
    }

    public String getResourceSex() {
        return resourceSex;
    }

    public String getResourceDateOfBirth() {
        return resourceDateOfBirth;
    }

    public Contact getResourceContact() {
        return resourceContact;
    }

    public Address getResourceAddress() {
        return resourceAddress;
    }

    public List<Order> getResourceOrderList() {
        return resourceOrderList;
    }

    public static class Builder {

        private Long resourceId;
        private Name resourceName;
        private String resourceSex;
        private String resourceDateOfBirth;
        private Contact resourceContact;
        private Address resourceAddress;
        private List<Order> resourceOrderList;

        public Builder(Name resourceName) {
            this.resourceName = resourceName;
        }

        public Builder id(Long id) {
            this.resourceId = id;
            return this;
        }

        public Builder name(Name name) {
            this.resourceName = name;
            return this;
        }

        public Builder sex(String sex) {
            this.resourceSex = sex;
            return this;
        }

        public Builder dateOfBirth(String dateOfBirth) {
            this.resourceDateOfBirth = dateOfBirth;
            return this;
        }

        public Builder contact(Contact contact) {
            this.resourceContact = contact;
            return this;
        }

        public Builder address(Address address) {
            this.resourceAddress = address;
            return this;
        }

        public Builder orderList(List<Order> orderList) {
            this.resourceOrderList = orderList;
            return this;
        }

        public Builder copy(CustomerResource customer) {
            this.resourceId = customer.id;
            this.resourceName = customer.resourceName;
            this.resourceSex = customer.resourceSex;
            this.resourceDateOfBirth = customer.resourceDateOfBirth;
            this.resourceContact = customer.resourceContact;
            this.resourceAddress = customer.resourceAddress;
            this.resourceOrderList = customer.resourceOrderList;
            return this;
        }

        public CustomerResource build() {
            return new CustomerResource(this);
        }

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "resourceId=" + id +
                ", resourceName=" + resourceName +
                ", resourceSex='" + resourceSex + '\'' +
                ", resourceDateOfBirth='" + resourceDateOfBirth + '\'' +
                ", resourceContact=" + resourceContact +
                ", resourceAddress=" + resourceAddress +
                ", resourceOrderList=" + resourceOrderList +
                '}';
    }
}
