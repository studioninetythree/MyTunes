package za.ac.cput.MyTunes.domain;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.MyTunes.factories.ContactFactory;

public class ContactTest {

    @Test
    public void testCreate() {
        Contact contact = ContactFactory.createContact("0215600032", "0112366999");
        Assert.assertEquals(contact.getHomePhoneNumber(), "0215600032");
        Assert.assertEquals(contact.getMobilePhoneNumber(), "0112366999");
    }

    @Test
    public void testUpdate() {
        Contact contact = ContactFactory.createContact("0256325982", "5698523102");
        Contact contactCopy = new Contact.Builder(contact.getMobilePhoneNumber()).copy(contact).homePhoneNumber("0213300000").build();
        Assert.assertEquals(contactCopy.getHomePhoneNumber(), "0213300000");
        Assert.assertEquals(contactCopy.getMobilePhoneNumber(), "5698523102");
    }

}
