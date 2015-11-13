package za.ac.cput.MyTunes.factories;

import za.ac.cput.MyTunes.domain.Contact;

public class ContactFactory {

    public static Contact createContact(String homePhoneNumber, String mobilePhoneNumber) {
        return new Contact.Builder(mobilePhoneNumber).homePhoneNumber(homePhoneNumber).build();
    }

}
