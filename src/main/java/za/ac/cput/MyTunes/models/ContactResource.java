package za.ac.cput.MyTunes.models;

import org.springframework.hateoas.ResourceSupport;

public class ContactResource extends ResourceSupport {
    private String resourceHomePhoneNumber;
    private String resourceMobilePhoneNumber;
    private String resourceEmail;

    private ContactResource() {}

    public ContactResource(Builder builder) {
        this.resourceHomePhoneNumber = builder.resourceHomePhoneNumber;
        this.resourceMobilePhoneNumber = builder.resourceMobilePhoneNumber;
        this.resourceEmail = builder.resourceEmail;
    }

    public String getResourceHomePhoneNumber() {
        return resourceHomePhoneNumber;
    }

    public String getResourceMobilePhoneNumber() {
        return resourceMobilePhoneNumber;
    }

    public String getResourceEmail() {
        return resourceEmail;
    }

    public static class Builder {

        private String resourceHomePhoneNumber;
        private String resourceMobilePhoneNumber;
        private String resourceEmail;

        public Builder(String resourceMobilePhoneNumber) {
            this.resourceMobilePhoneNumber = resourceMobilePhoneNumber;
        }

        public Builder homePhoneNumber(String homePhoneNumber) {
            this.resourceHomePhoneNumber = homePhoneNumber;
            return this;
        }

        public Builder mobilePhoneNumber(String mobilePhoneNumber) {
            this.resourceMobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.resourceEmail = email;
            return this;
        }

        public Builder copy(ContactResource contact) {
            this.resourceHomePhoneNumber = contact.resourceHomePhoneNumber;
            this.resourceMobilePhoneNumber = contact.resourceMobilePhoneNumber;
            return this;
        }

        public ContactResource build() {
            return new ContactResource(this);
        }

    }

    @Override
    public String toString() {
        return "ContactResource{" +
                "HomePhoneNumber='" + resourceHomePhoneNumber + '\'' +
                ", MobilePhoneNumber='" + resourceMobilePhoneNumber + '\'' +
                ", Email='" + resourceEmail + '\'' +
                '}';
    }
}
