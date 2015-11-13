package za.ac.cput.MyTunes.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Contact implements Serializable {

    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String email;

    private Contact() {}

    public Contact(Builder builder) {
        this.homePhoneNumber = builder.homePhoneNumber;
        this.mobilePhoneNumber = builder.mobilePhoneNumber;
        this.email = builder.email;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {

        private String homePhoneNumber;
        private String mobilePhoneNumber;
        private String email;

        public Builder(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
        }

        public Builder homePhoneNumber(String homePhoneNumber) {
            this.homePhoneNumber = homePhoneNumber;
            return this;
        }

        public Builder mobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder copy(Contact contact) {
            this.homePhoneNumber = contact.homePhoneNumber;
            this.mobilePhoneNumber = contact.mobilePhoneNumber;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }

    }

    @Override
    public String toString() {
        return "Contact{" +
                "HomePhoneNumber='" + homePhoneNumber + '\'' +
                ", MobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }

}
